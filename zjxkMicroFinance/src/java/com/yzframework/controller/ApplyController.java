package com.yzframework.controller;

import java.sql.Timestamp;
import java.sql.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yzframework.model.Mapply;
import com.yzframework.service.ApplyService;

/**
 * @author Administrator
 * 
 */
@Controller
public class ApplyController {
    protected final Log logger = LogFactory.getLog(getClass());

    @Resource
    private ApplyService applyService;
    
    @RequestMapping("jsp/saveApply")
    @ResponseBody
    public String saveApply(Mapply model) throws Exception {
       //插入字段编辑
       model.setStatus("0");
       model.setApplydate(new Timestamp(System.currentTimeMillis()));
       model.setCreateid("net");
       model.setUpdateid("net");
       model.setCreatetime(new Timestamp(System.currentTimeMillis()));
       model.setUpdatetime(new Timestamp(System.currentTimeMillis()));
       
       applyService.save(model);
       return JSON.toJSONString("恭喜您！您已申请成功，我们将尽快处理您的申请。");
    }

}