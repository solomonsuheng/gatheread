package com.gatheread.DB;

/**
 * @ClassName: DBInterface
 * @Description: ���ݿ�ӿ�,����ӿڱ��
 * @author ���պ�
 * @date 2014-5-14 ����4:43:46
 */
public interface DBInterface {
	/**
	 * @Title: initDB
	 * @Description: TODO(��ʼ�����ݿ�)
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public boolean initDB();

	/**
	 * @Title: destroyDB
	 * @Description: TODO(�������ݿ���Դ)
	 * @param @return �趨�ļ�
	 * @return boolean ��������
	 * @throws
	 */
	public boolean destroyDB();
	
	
}
