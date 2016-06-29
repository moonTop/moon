package com.yzframework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yzframework.base.Page;
import com.yzframework.model.Morg;
import com.yzframework.model.Mrole;
import com.yzframework.service.MOrgService;
import com.yzframework.service.MRoleService;

@Controller
@RequestMapping("/views/Lookup")
public class LookupController {

	@Resource
	private MOrgService mOrgService;
	@Resource
	private MRoleService mRoleService;

    /**
     * 部门编码，部门名称查找带回
     */
    @RequestMapping("/org")
    public ModelAndView company(Page page, Morg model) throws Exception {
        ModelAndView mav = new ModelAndView();
        model.setStatus("1");
        Page p = mOrgService.findPage(page, model);
        mav.addObject("page", p);
        mav.addObject("model", model);
        mav.setViewName("LookupOrg");

        return mav;
    }

    /**
     * 角色名称查找带回
     */
    @RequestMapping("/roles")
    public ModelAndView role(Page page, Mrole model) throws Exception {
        ModelAndView mav = new ModelAndView();
        model.setStatus("1");
        Page p = mRoleService.findPageRole(page, model);
        mav.addObject("page", p);
        mav.addObject("model", model);
        mav.setViewName("LookupRoles");

        return mav;
    }
    

}
