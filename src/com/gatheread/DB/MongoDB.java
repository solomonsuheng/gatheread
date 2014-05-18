package com.gatheread.DB;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

/**
 * @ClassName: MongoDB
 * @Description: 实现MongoDB数据库,实现DB Interface接口
 * @author 葛苏恒
 * @date 2014-5-14 下午4:46:25
 */
public class MongoDB implements DBInterface {
	// 数据域
	private Mongo mongo = null;// MongoDB
	private DB db = null;// 数据库
	private DBCollection dbc = null;// Collection
	private DBCursor cur = null;// Collection游标

	private String connURL = "";// 连接mongodb的URL
	private int dbPort = 0;// 连接mongodb的端口号码,通常为27017
	private String dbName = "";// 所要连接到的数据库名字
	private String collectionName = "";// 所要连接到的collectionName

	// 构造函数
	public MongoDB() {// 参数构造函数自动使用默认值填充字段,并调用有参构造函数
		// 自动填充的为本机mongoDB:27017端口下mydb库users Collection
		this("localhost", 27017, "mydb", "users");
	}

	public MongoDB(String connURL, int dbPort, String dbName,
			String collectionName) {
		this.connURL = connURL;
		this.dbPort = dbPort;
		this.dbName = dbName;
		this.collectionName = collectionName;
	}

	// 函数
	public boolean initDB() {
		// TODO Auto-generated method stub
		boolean connFlag = false;
		try {
			this.mongo = new Mongo(this.connURL, this.dbPort);
			this.db = this.mongo.getDB(this.dbName);
			//db.authenticate("admin", "5Jqnas41bR".toCharArray());
			this.dbc = this.db.getCollection(this.collectionName);
			connFlag = true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connFlag;
	}

	public boolean destroyDB() {
		// TODO Auto-generated method stub
		if (this.mongo != null) {
			this.mongo.close();
		}
		this.mongo = null;
		this.db = null;
		this.dbc = null;
		this.cur = null;
		return false;
	}

	public String toString() {// 返回基本信息用作参考
		return "Info:" + this.connURL + ":" + this.dbPort + "/" + this.dbName
				+ "." + this.collectionName;
	}

	public static void main(String[] args) {
		MongoDB m = new MongoDB();
		m.initDB();
		System.out.println(m.toString());
	}

	/**
	 * @return mongo
	 */
	public Mongo getMongo() {
		return mongo;
	}

	/**
	 * @param mongo
	 *            要设置的 mongo
	 */
	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}

	/**
	 * @return db
	 */
	public DB getDb() {
		return db;
	}

	/**
	 * @param db
	 *            要设置的 db
	 */
	public void setDb(DB db) {
		this.db = db;
	}

	/**
	 * @return dbc
	 */
	public DBCollection getDbc() {
		return dbc;
	}

	/**
	 * @param dbc
	 *            要设置的 dbc
	 */
	public void setDbc(DBCollection dbc) {
		this.dbc = dbc;
	}

	/**
	 * @return cur
	 */
	public DBCursor getCur() {
		return cur;
	}

	/**
	 * @param cur
	 *            要设置的 cur
	 */
	public void setCur(DBCursor cur) {
		this.cur = cur;
	}

	/**
	 * @return connURL
	 */
	public String getConnURL() {
		return connURL;
	}

	/**
	 * @param connURL
	 *            要设置的 connURL
	 */
	public void setConnURL(String connURL) {
		this.connURL = connURL;
	}

	/**
	 * @return dbPort
	 */
	public int getDbPort() {
		return dbPort;
	}

	/**
	 * @param dbPort
	 *            要设置的 dbPort
	 */
	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}

	/**
	 * @return dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName
	 *            要设置的 dbName
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return collectionName
	 */
	public String getCollectionName() {
		return collectionName;
	}

	/**
	 * @param collectionName
	 *            要设置的 collectionName
	 */
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	// Setter & Getter

}
