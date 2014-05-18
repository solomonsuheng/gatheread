package com.gatheread.DAO;

import java.util.ArrayList;
import java.util.List;

import com.gatheread.DB.MongoDB;
import com.mongodb.BasicDBObject;

public class ReadMongoDAO implements ReadDAO {

	// ������
	private MongoDB mongoDB = null;

	/**
	 * @return mongoDB
	 */
	public MongoDB getMongoDB() {
		return mongoDB;
	}

	/**
	 * @param mongoDB
	 *            Ҫ���õ� mongoDB
	 */
	public void setMongoDB(MongoDB mongoDB) {
		this.mongoDB = mongoDB;
	}

	public boolean init() {
		// TODO Auto-generated method stub
		this.setMongoDB(new MongoDB("localhost", 27017, "news", "news"));
		this.getMongoDB().initDB();
		return true;
	}

	// ����ƫ�õ�ֵ��ȡƫ�þ۶�list
	public List getNewsByPrefer(String uname) {
		// TODO Auto-generated method stub
		List newslist = null;
		String uprefer = this.getUserPrefer(uname);
		// ����ƫ�û�ȡ�۶�
		List<String> list = this.getAllNewsSites();// ��ȡ�����ռ�������վ��
		if (list.contains(uprefer)) {// �������վ���и�ƫ������ϵĵ�,����ƫ������
			BasicDBObject bobj = new BasicDBObject();
			bobj.put("nweb", uprefer);// ��ѯ���ڸ�upreferƫ�õ�nweb
			BasicDBObject bobk = new BasicDBObject();
			bobk.put("_id", 0);// ����mongoDB projection����
			this.getMongoDB().setDbc(
					this.getMongoDB().getDb().getCollection("news"));// ��ȡnews
																		// collection
			this.getMongoDB().setCur(
					this.getMongoDB().getDbc().find(bobj, bobk));
			newslist = this.getMongoDB().getCur().toArray();// �����й��ڸ�ƫ�õ����ݷ���list��,����
		} else {
			// ƫ��û����List��,��ȡ���ž۶�
			this.getMongoDB().setDbc(
					this.getMongoDB().getDb().getCollection("news"));// �ı�collection
			BasicDBObject objr = new BasicDBObject();
			BasicDBObject objk = new BasicDBObject();
			objk.put("_id", 0);// ����mongoDB projection����
			newslist = this.getMongoDB().getDbc().find(objr, objk).toArray();// ��ѯ�������ž۶���Ϣ����newslist����
		}
		return newslist;
	}

	// ��ȡ����Mongdb�д�ŵ�վ��,���й���վ�����Ϣ����newsstore collection��
	public List<String> getAllNewsSites() {
		this.getMongoDB().setDbc(
				this.getMongoDB().getDb().getCollection("newsstore"));
		BasicDBObject objr = new BasicDBObject();
		BasicDBObject objk = new BasicDBObject();
		objk.put("_id", 0);// ���ٴ���
		this.getMongoDB().setCur(this.getMongoDB().getDbc().find(objr, objk));
		List<String> newname = new ArrayList<String>();
		while (this.getMongoDB().getCur().hasNext()) {
			newname.add((this.getMongoDB().getCur().next().get("name")
					.toString()));
		}
		return newname;
	}

	// ��ȡ�û�ƫ��
	public String getUserPrefer(String uname) {
		String uprefer = "";
		this.getMongoDB().setDbc(
				this.getMongoDB().getDb().getCollection("user"));
		BasicDBObject objr = new BasicDBObject();
		BasicDBObject objk = new BasicDBObject();
		objr.put("uname", uname);
		objk.put("_id", 0);// ���ٴ���
		objk.put("uname", 0);// ���ٴ���
		objk.put("upwd", 0);// ���ٴ���s
		this.getMongoDB().setCur(this.getMongoDB().getDbc().find(objr, objk));
		if (this.getMongoDB().getCur().hasNext()) {
			uprefer = this.getMongoDB().getCur().next().get("uprefer")
					.toString();
		}
		return uprefer;
	}

	public List getAllNews() {
		// TODO Auto-generated method stub
		List newslist = null;
		this.getMongoDB().setDbc(
				this.getMongoDB().getDb().getCollection("news"));
		BasicDBObject objr = new BasicDBObject();
		BasicDBObject objk = new BasicDBObject();
		objk.put("_id", 0);//���ٴ���
		this.getMongoDB().setCur(this.getMongoDB().getDbc().find(objr, objk));
		newslist = this.getMongoDB().getDbc().find(objr, objk).toArray();// ��ѯ�������ž۶���Ϣ����newslist����
		return newslist;
	}

	public static void main(String[] args) {
		ReadMongoDAO dao = new ReadMongoDAO();

		dao.init();
		System.out.println(dao.getNewsByPrefer("gesuheng"));
		dao.destroy();

	}

	public boolean destroy() {
		// TODO Auto-generated method stub
		this.getMongoDB().destroyDB();
		return true;
	}

}
