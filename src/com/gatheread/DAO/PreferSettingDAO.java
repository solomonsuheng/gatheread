package com.gatheread.DAO;

/**
 * @ClassName: SettingPrefer
 * @Description: ����ƫ�ýӿ�
 * @author ���պ�
 * @date 2014-5-15 ����11:06:14
 */
public interface PreferSettingDAO {
	public boolean init();// ��ʼ��DAO������Ϣ

	public boolean setPrefer(String uname, String uprefer);

	public boolean destroy();
}
