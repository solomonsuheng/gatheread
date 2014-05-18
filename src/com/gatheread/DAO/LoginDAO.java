package com.gatheread.DAO;

/**
 * @ClassName: LoginDAO
 * @Description: 登录接口
 * @author 葛苏恒
 * @date 2014-5-14 下午5:05:17
 */
public interface LoginDAO {
	public boolean init();// 初始化DAO基本信息

	public boolean isByNameAndPwd(String uname, String upwd);

	public boolean destroy();
}
