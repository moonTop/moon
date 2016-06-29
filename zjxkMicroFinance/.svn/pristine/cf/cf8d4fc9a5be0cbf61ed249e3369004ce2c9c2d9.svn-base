package com.yzframework.service;

import java.util.List;

import com.yzframework.base.Page;
import com.yzframework.model.Mrole;
import com.yzframework.model.Muser;

public interface MuserService {

	
	/**
	 * 根据ID获取登录用户信息
	 * 
	 * @模块  通用
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Muser findByid(String id) throws Exception;
    /**
     * 根据条件获取登录用户信息
     * 
     * @模块  通用
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public List<Muser> findByModel(Muser model) throws Exception;
    /**
     * 根据USERID获取登录用户信息
     * 
     * @模块  通用
     * 
     * @param userid
     * @return
     * @throws Exception
     */
    public List<Muser> findByUserid(String userid) throws Exception;
	/**
	 * 根据登录帐号验证该帐号是否存在
	 * 
	 * @模块  用户登录
	 * 
	 * @param muser  
	 * @return
	 * @throws Exception
	 *
	 */
	public List<Muser> find01(Muser muser) throws Exception;
	/**
	 * 修改用户信息
	 * 
	 * @模块     考生信息
	 * 
	 * @param muser  
	 * @return
	 * @throws Exception
	 */
	public void update(Muser muser) throws Exception;
	
	/**
	 * 测试用户分页查询
	 * 
	 * @模块名称 测试用户
	 */
	public Page findPage01(Page page, Muser model);
	
	/**
     * 后台用户分页查询
     * 
     * @模块名称 测试用户
     */
    public Page findPage02(Page page, Muser model);
   
	
	/**
	 * 测试用户-保存记录
	 * 
	 * @模块名称 测试用户
	 */
	public void save(Muser model) throws Exception;
	/**
	 * 根据帐号验证是否存在
	 * <p>模块  企业注册</p>
	 * @param model
	 * @return
	 */
	public Boolean find03(Muser model);
	/**
     * 取得准考证最大值
     * <p>模块  测试用户导入</p>
     * @param model
     * @return
     */
    public String find04(String companyid);
    
    public List<Mrole> findMroleList(String userid) throws Exception;

}
