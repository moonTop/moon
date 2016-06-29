package com.yzframework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yzframework.base.ActionContext;
import com.yzframework.base.AjaxDone;
import com.yzframework.base.SessionInfo;
import com.yzframework.bean.BeanTreeModule;
import com.yzframework.model.Fmodule;
import com.yzframework.model.Muser;
import com.yzframework.service.FmoduleService;
import com.yzframework.service.MuserService;
import com.yzframework.utils.PasswordUtil;

@Controller
public class MainController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Resource
    private FmoduleService fmoduleService;
    
    @Resource
    private MuserService muserService;
    
    /**
     * 根据用户拥有角色，设定可操作的模块
     * @return
     * @throws Exception
     */
    @RequestMapping("/views/loadMain")
    public ModelAndView loadMain() throws Exception {
        ModelAndView mav = new ModelAndView();
        List<BeanTreeModule> menuList = getChidren("0");
        mav.setViewName("main");
        mav.addObject("menuList", menuList);
        return mav;
    }
    
    /**
     * 退出系统
     * @return
     * @throws Exception
     */
    @RequestMapping("/views/logout")
    public ModelAndView logout(HttpSession session) throws Exception{
    	ModelAndView mav = new ModelAndView("redirect:/logon.do");
    	session.invalidate();
    	return mav;
    }
    
    /**
     * 修改密码
     * @return
     * @throws Exception
     */
    @RequestMapping("/views/changepsinit")
    public ModelAndView changepasswordinit() throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("changeps");
        return mav;
    }
    
    /*
     * 密码修改
     */
    @RequestMapping("/views/changeps")
    @ResponseBody
    public String changepassword(String oldpw, String newpw, String comfirmpw) {
        AjaxDone ajaxDone = new AjaxDone();
        SessionInfo session = ActionContext.getSession();
        String uuid = session.getUserUUid();
        try {
            Muser muser = muserService.findByid(uuid);
            if (muser == null) {
                ajaxDone.setStatusCode(AjaxDone.FAIL);
                ajaxDone.setMessage("用户不存在，请重新登录");
                return JSON.toJSONString(ajaxDone);
            }
            if (!PasswordUtil.validatePassword(muser.getPassword(), oldpw)) {
                ajaxDone.setStatusCode(AjaxDone.FAIL);
                ajaxDone.setMessage("旧密码输出错误");
                return JSON.toJSONString(ajaxDone);
            }

            muser.setPassword(PasswordUtil.encryPassword(newpw));
            muserService.update(muser);
            
            ajaxDone.setStatusCode(AjaxDone.SUCCESS);
            ajaxDone.setMessage(AjaxDone.SUCCESS_MSG);
            ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
            return JSON.toJSONString(ajaxDone);
        } catch (Exception e) {
            logger.error(null, e);
            ajaxDone.setStatusCode(AjaxDone.FAIL);
            ajaxDone.setMessage(AjaxDone.FAIL_MSG);
            return JSON.toJSONString(ajaxDone);
        }
    }

    /**
   	 * 查询子节点
   	 * 
   	 * @param fileId
   	 * @return
   	 */
   	private List<BeanTreeModule> getChidren(String parentid) throws Exception {
   		List<Fmodule> menuList = fmoduleService.findModuleList(parentid);
   		List<BeanTreeModule> lstChild = new ArrayList<BeanTreeModule>();
   		for (Fmodule fmenuT : menuList) {
   			BeanTreeModule beanTree = new BeanTreeModule();
   			beanTree.setId(fmenuT.getId());
   			beanTree.setModname(fmenuT.getModname());
   			beanTree.setLinkurl(fmenuT.getLinkurl());
   			beanTree.setPicurl(fmenuT.getPicurl());
   			beanTree.setEndflg(fmenuT.getEndflg());
   			
   			List<BeanTreeModule> tempLst = new ArrayList<BeanTreeModule>();
   			// 子节点递归查询
   			if ("0".equals(fmenuT.getEndflg())) {
   				tempLst = getChidren(fmenuT.getId());
   			}
   			
			beanTree.setChildren(tempLst);
			
			// 树形节点添加
			if ("0".equals(parentid)) {
				if (tempLst.size() > 0) {
					lstChild.add(beanTree);
				}
			} else {
				lstChild.add(beanTree);
			}
   			
   		}
   		return lstChild;
   	}
}
