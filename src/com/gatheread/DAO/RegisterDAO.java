package com.gatheread.DAO;

/**
 * @ClassName: RegisterDAO
 * @Description: ע���û��ӿ�
 * @author ���պ�
 * @date 2014-5-14 ����7:10:28
 */
public interface RegisterDAO {
	public boolean init();// ��ʼ��DAO������Ϣ

	public boolean saveUser(String uname, String upwd, String uprefer);

	public boolean destroy();
}
