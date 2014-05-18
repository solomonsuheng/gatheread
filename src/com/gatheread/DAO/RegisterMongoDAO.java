package com.gatheread.DAO;

import com.gatheread.DB.MongoDB;
import com.mongodb.BasicDBObject;

/**
 * @ClassName: RegisterMongoDAO
 * @Description: MongoDB注册用户DAO
 * @author 葛苏恒
 * @date 2014-5-14 下午7:30:14
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
	 *            要设置的 mongoDB
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
		// 检查是否已经存在了该用户
		BasicDBObject bobj = new BasicDBObject();
		bobj.put("uname", uname);// 该用户名是否已经存在了
		this.getMongoDB().setCur(this.getMongoDB().getDbc().find(bobj));

		if (this.getMongoDB().getCur().hasNext()) {
			flag = false;// 存在该用户,则无法进行注册
		} else {
			// 该用户存在可以进行存储
			if (!(uname == null || "".equals(uname) || upwd == null || ""
					.equals(upwd))) {// 检测字段不能为空

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
