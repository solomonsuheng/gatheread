package com.gatheread.DAO;

import java.util.List;

/**
 * @ClassName: ReadDAO
 * @Description: ��ȡ�۶�DAO
 * @author ���պ�
 * @date 2014-5-14 ����7:49:28
 */
public interface ReadDAO {
	public boolean init();// ��ʼ��DAO������Ϣ

	public List getNewsByPrefer(String uname);// �����û���ȡƫ�û�ȡ�۶�
	public List getAllNews();//��ȡ���о۶�

	public boolean destroy();
}
