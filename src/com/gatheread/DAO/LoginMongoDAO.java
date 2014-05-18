package com.gatheread.DAO;

import com.gatheread.DB.DBInterface;
import com.gatheread.DB.MongoDB;
import com.mongodb.BasicDBObject;

public class LoginMongoDAO implements LoginDAO {
	// ������
	private MongoDB mongoDB = null;

	/**
	 * @param mongoDB
	 *            Ҫ���õ� mongoDB
	 */
	public void setMongoDB(MongoDB mongoDB) {
		this.mongoDB = mongoDB;
	}

	public boolean init() {
		// TODO Auto-generated method stub
		//mongodb-env-8558543.j.dnr.kz
		this.mongoDB = new MongoDB("localhost", 27017, "news", "user");
		this.mongoDB.initDB();
		return true;
	}

	public boolean isByNameAndPwd(String uname, String upwd) {
		// TODO Auto-generated method stub
		// ��ѯ����
		BasicDBObject obj = new BasicDBObject();
		// Projection����
		BasicDBObject objk = new BasicDBObject();
		// ���ٴ���projection��������
		objk.put("_id", 0);
		objk.put("uname", 0);
		objk.put("upwd", 0);

		obj.put("uname", uname);
		obj.put("upwd", upwd);

		this.mongoDB.setCur(this.mongoDB.getDbc().find(obj, objk));
		if (this.mongoDB.getCur().hasNext()) {
			System.out.println("@src/com/gatheread/DAO/LoginMongoDAO#���ڸ��û�:"
					+ this.mongoDB.getCur().next());
			return true;
		} else {
			System.out.println("@src/com/gatheread/DAO/LoginMongoDAO#�����ڸ��û�");
		}
		return false;
	}

	/**
	 * @return mongoDB
	 */
	public MongoDB getMongoDB() {
		return mongoDB;
	}

	public static void main(String[] args) {
		LoginDAO dao = new LoginMongoDAO();
		dao.init();
		dao.isByNameAndPwd("admin", "admin");
	}

	public boolean destroy() {
		// TODO Auto-generated method stub
		this.getMongoDB().destroyDB();
		return true;
	}

}
