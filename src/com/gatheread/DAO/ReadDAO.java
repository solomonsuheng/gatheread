package com.gatheread.DAO;

import java.util.List;

/**
 * @ClassName: ReadDAO
 * @Description: 获取聚读DAO
 * @author 葛苏恒
 * @date 2014-5-14 下午7:49:28
 */
public interface ReadDAO {
	public boolean init();// 初始化DAO基本信息

	public List getNewsByPrefer(String uname);// 根据用户获取偏好获取聚读
	public List getAllNews();//获取所有聚读

	public boolean destroy();
}
