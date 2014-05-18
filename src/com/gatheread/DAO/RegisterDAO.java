package com.gatheread.DAO;

/**
 * @ClassName: RegisterDAO
 * @Description: 注册用户接口
 * @author 葛苏恒
 * @date 2014-5-14 下午7:10:28
 */
public interface RegisterDAO {
	public boolean init();// 初始化DAO基本信息

	public boolean saveUser(String uname, String upwd, String uprefer);

	public boolean destroy();
}
