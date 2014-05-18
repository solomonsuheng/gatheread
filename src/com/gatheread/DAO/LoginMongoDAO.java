package com.gatheread.DAO;

import com.gatheread.DB.DBInterface;
import com.gatheread.DB.MongoDB;
import com.mongodb.BasicDBObject;

public class LoginMongoDAO implements LoginDAO {
	// 数据域
	private MongoDB mongoDB = null;

	/**
	 * @param mongoDB
	 *            要设置的 mongoDB
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
		// 查询对象
		BasicDBObject obj = new BasicDBObject();
		// Projection设置
		BasicDBObject objk = new BasicDBObject();
		// 减少带宽projection无需数据
		objk.put("_id", 0);
		objk.put("uname", 0);
		objk.put("upwd", 0);

		obj.put("uname", uname);
		obj.put("upwd", upwd);

		this.mongoDB.setCur(this.mongoDB.getDbc().find(obj, objk));
		if (this.mongoDB.getCur().hasNext()) {
			System.out.println("@src/com/gatheread/DAO/LoginMongoDAO#存在该用户:"
					+ this.mongoDB.getCur().next());
			return true;
		} else {
			System.out.println("@src/com/gatheread/DAO/LoginMongoDAO#不存在该用户");
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
