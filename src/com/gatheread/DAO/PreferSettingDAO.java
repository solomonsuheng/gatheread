package com.gatheread.DAO;

/**
 * @ClassName: SettingPrefer
 * @Description: 设置偏好接口
 * @author 葛苏恒
 * @date 2014-5-15 上午11:06:14
 */
public interface PreferSettingDAO {
	public boolean init();// 初始化DAO基本信息

	public boolean setPrefer(String uname, String uprefer);

	public boolean destroy();
}
