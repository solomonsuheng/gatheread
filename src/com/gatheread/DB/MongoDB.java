package com.gatheread.DB;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

/**
 * @ClassName: MongoDB
 * @Description: ʵ��MongoDB���ݿ�,ʵ��DB Interface�ӿ�
 * @author ���պ�
 * @date 2014-5-14 ����4:46:25
 */
public class MongoDB implements DBInterface {
	// ������
	private Mongo mongo = null;// MongoDB
	private DB db = null;// ���ݿ�
	private DBCollection dbc = null;// Collection
	private DBCursor cur = null;// Collection�α�

	private String connURL = "";// ����mongodb��URL
	private int dbPort = 0;// ����mongodb�Ķ˿ں���,ͨ��Ϊ27017
	private String dbName = "";// ��Ҫ���ӵ������ݿ�����
	private String collectionName = "";// ��Ҫ���ӵ���collectionName

	// ���캯��
	public MongoDB() {// �������캯���Զ�ʹ��Ĭ��ֵ����ֶ�,�������вι��캯��
		// �Զ�����Ϊ����mongoDB:27017�˿���mydb��users Collection
		this("localhost", 27017, "mydb", "users");
	}

	public MongoDB(String connURL, int dbPort, String dbName,
			String collectionName) {
		this.connURL = connURL;
		this.dbPort = dbPort;
		this.dbName = dbName;
		this.collectionName = collectionName;
	}

	// ����
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

	public String toString() {// ���ػ�����Ϣ�����ο�
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
	 *            Ҫ���õ� mongo
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
	 *            Ҫ���õ� db
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
	 *            Ҫ���õ� dbc
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
	 *            Ҫ���õ� cur
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
	 *            Ҫ���õ� connURL
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
	 *            Ҫ���õ� dbPort
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
	 *            Ҫ���õ� dbName
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
	 *            Ҫ���õ� collectionName
	 */
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	// Setter & Getter

}
