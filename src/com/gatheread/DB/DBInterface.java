package com.gatheread.DB;

/**
 * @ClassName: DBInterface
 * @Description: 数据库接口,面向接口编程
 * @author 葛苏恒
 * @date 2014-5-14 下午4:43:46
 */
public interface DBInterface {
	/**
	 * @Title: initDB
	 * @Description: TODO(初始化数据库)
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean initDB();

	/**
	 * @Title: destroyDB
	 * @Description: TODO(回收数据库资源)
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean destroyDB();
	
	
}
