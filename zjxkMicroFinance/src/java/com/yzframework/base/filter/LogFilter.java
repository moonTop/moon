package com.yzframework.base.filter;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.yzframework.base.ActionContext;
import com.yzframework.base.AjaxDone;
import com.yzframework.base.JSONPResponseWrapper;
import com.yzframework.base.LogXml;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Mlog;
import com.yzframework.service.MlogService;

public class LogFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(this.getClass());
    
    @Resource
    private LogXml logXml;
    public void setLogXml(LogXml logXml) {
        this.logXml = logXml;
    }
    
    @Resource
    private IDAO dao;
    public void setDao(IDAO dao) {
        this.dao = dao;
    }
    
    @Resource
    private MlogService mlogService;

    public void setMlogService(MlogService mlogService) {
        this.mlogService = mlogService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        boolean needfilter = false;
        String uri = request.getRequestURI();
        if (uri.indexOf(".do") != -1) {
            needfilter = true;
        }
        
        if (needfilter && logXml.hasUri(uri)){
            String contentType = request.getContentType();
            if (contentType != null && contentType.indexOf("multipart/form-data") != -1) {
                request = new CommonsMultipartResolver().resolveMultipart(request);
            }

            Map<String,String> map = logXml.get(uri);
            // 取得日志信息
            String target = "";
            Map<String, String> parameterMap = request.getParameterMap();
            String logkey = map.get("columnname");
            String tablename = map.get("tablename");
            for(Iterator<String> it = parameterMap.keySet().iterator(); it.hasNext();){
                String key = it.next();
                if (logkey.toLowerCase().equals(key.toLowerCase())) {
                    target = request.getParameter(key);
                    break;
                }
            }
            // 根据ID取得日志信息
            if (StringUtils.isEmpty(target) && !StringUtils.isEmpty(request.getParameter("id"))) {
                String sql = "SELECT " + logkey + " FROM " + tablename + " WHERE id= '" + request.getParameter("id") + "'";
                List<Map<String, Object>> dataList = dao.findMapBySQL(sql);
                if (dataList.size() > 0) {
                    target = (String)dataList.get(0).get(logkey);
                }
            }
            // 使用我们自定义的响应包装器来包装原始的ServletResponse
            JSONPResponseWrapper responseWrapper = new JSONPResponseWrapper((HttpServletResponse)response);
            chain.doFilter(request, responseWrapper);
            byte[] result = responseWrapper.getResponseData();

            JSONObject josnResult = null;
            try {
                josnResult = JSON.parseObject(new String(result));
                String statusCode = (String)josnResult.get("statusCode");
                
                // AJAX处理正常
                if (AjaxDone.SUCCESS.equals(statusCode)) {
                    Mlog model = new Mlog();
                    model.setModulename(map.get("modluename"));
                    model.setOpstyle(map.get("opname"));
                    model.setOpcontent(map.get("columncomment") + "【" + target + "】");
                    model.setOpperson(ActionContext.getSession().getUserid());
                    model.setOptime(new Timestamp(System.currentTimeMillis()));
                    model.setIp(ActionContext.getSession().getIp());
                    
                    try {
                        mlogService.save(model);
                    } catch(Exception e){
                        logger.error("日志信息写入失败！");
                        logger.error(e.getStackTrace());
                    }
                }
            } catch(JSONException e){
            }
            
            // 输出最终的结果
            response.getOutputStream().write(result);
            response.getOutputStream().flush();
        } else {
            chain.doFilter(request, response);
        }
    }
}
