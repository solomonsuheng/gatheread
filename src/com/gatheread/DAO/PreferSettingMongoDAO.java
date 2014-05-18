package com.gatheread.DAO;

import com.gatheread.DB.MongoDB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PreferSettingMongoDAO implements PreferSettingDAO {
	// 数据域
	private MongoDB mongoDB = null;

	/**
	 * @return mongoDB
	 */
	public MongoDB getMongoDB() {
		return mongoDB;
	}

	/**
	 * @param mongoDB
	 *            要设置的 mongoDB
	 */
	public void setMongoDB(MongoDB mongoDB) {
		this.mongoDB = mongoDB;
	}

	public boolean init() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		this.mongoDB = new MongoDB("localhost", 27017, "news", "user");
		this.mongoDB.initDB();
		return true;
	}

	public boolean setPrefer(String uname, String uprefer) {
		// TODO Auto-generated method stub
		DBObject updateCondition = new BasicDBObject();
		updateCondition.put("uname", uname);

		DBObject updatedValue = new BasicDBObject();
		updatedValue.put("uprefer", uprefer);

		DBObject updateSetValue = new BasicDBObject("$set", updatedValue);
		this.getMongoDB().getDbc().update(updateCondition, updateSetValue);
		return true;
	}

	public static void main(String[] args) {
		PreferSettingMongoDAO p = new PreferSettingMongoDAO();
		p.init();
		p.setPrefer("admin", "hehe");
		p.destroy();
	}

	public boolean destroy() {
		// TODO Auto-generated method stub
		this.getMongoDB().destroyDB();
		return true;
	}

}
