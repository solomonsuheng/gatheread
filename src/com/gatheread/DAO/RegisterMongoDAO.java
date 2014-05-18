package com.gatheread.DAO;

import com.gatheread.DB.MongoDB;
import com.mongodb.BasicDBObject;

/**
 * @ClassName: RegisterMongoDAO
 * @Description: MongoDBע���û�DAO
 * @author ���պ�
 * @date 2014-5-14 ����7:30:14
 */
public class RegisterMongoDAO implements RegisterDAO {
	private MongoDB mongoDB = new MongoDB();

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
		this.mongoDB = new MongoDB("localhost", 27017, "news", "user");
		this.mongoDB.initDB();
		return true;
	}

	public boolean saveUser(String uname, String upwd, String uprefer) {
		// TODO Auto-generated method stub
		boolean flag = false;
		// ����Ƿ��Ѿ������˸��û�
		BasicDBObject bobj = new BasicDBObject();
		bobj.put("uname", uname);// ���û����Ƿ��Ѿ�������
		this.getMongoDB().setCur(this.getMongoDB().getDbc().find(bobj));

		if (this.getMongoDB().getCur().hasNext()) {
			flag = false;// ���ڸ��û�,���޷�����ע��
		} else {
			// ���û����ڿ��Խ��д洢
			if (!(uname == null || "".equals(uname) || upwd == null || ""
					.equals(upwd))) {// ����ֶβ���Ϊ��

				bobj = new BasicDBObject();
				bobj.put("uname", uname);
				bobj.put("upwd", upwd);
				bobj.put("uprefer", uprefer);
				this.getMongoDB().getDbc().save(bobj);
				flag = true;
			}
		}
		return flag;
	}

	public boolean destroy() {
		// TODO Auto-generated method stub
		this.getMongoDB().destroyDB();
		return true;
	}

	public static void main(String[] args) {
		RegisterDAO d = new RegisterMongoDAO();
		d.init();
		d.saveUser("adamin", "admin", "admin");
		d.destroy();
	}
}
