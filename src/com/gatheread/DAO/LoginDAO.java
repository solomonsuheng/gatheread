package com.gatheread.DAO;

/**
 * @ClassName: LoginDAO
 * @Description: ��¼�ӿ�
 * @author ���պ�
 * @date 2014-5-14 ����5:05:17
 */
public interface LoginDAO {
	public boolean init();// ��ʼ��DAO������Ϣ

	public boolean isByNameAndPwd(String uname, String upwd);

	public boolean destroy();
}
