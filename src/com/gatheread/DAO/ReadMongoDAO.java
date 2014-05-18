package com.gatheread.DAO;

import java.util.ArrayList;
import java.util.List;

import com.gatheread.DB.MongoDB;
import com.mongodb.BasicDBObject;

public class ReadMongoDAO implements ReadDAO {

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
		this.setMongoDB(new MongoDB("localhost", 27017, "news", "news"));
		this.getMongoDB().initDB();
		return true;
	}

	// 根据偏好的值获取偏好聚读list
	public List getNewsByPrefer(String uname) {
		// TODO Auto-generated method stub
		List newslist = null;
		String uprefer = this.getUserPrefer(uname);
		// 根据偏好获取聚读
		List<String> list = this.getAllNewsSites();// 获取所有收集的新闻站点
		if (list.contains(uprefer)) {// 如果新闻站点有跟偏好相符合的的,进行偏好搜索
			BasicDBObject bobj = new BasicDBObject();
			bobj.put("nweb", uprefer);// 查询关于该uprefer偏好的nweb
			BasicDBObject bobk = new BasicDBObject();
			bobk.put("_id", 0);// 减少mongoDB projection带宽
			this.getMongoDB().setDbc(
					this.getMongoDB().getDb().getCollection("news"));// 获取news
																		// collection
			this.getMongoDB().setCur(
					this.getMongoDB().getDbc().find(bobj, bobk));
			newslist = this.getMongoDB().getCur().toArray();// 将所有关于该偏好的数据放入list中,返回
		} else {
			// 偏好没有在List中,获取新闻聚读
			this.getMongoDB().setDbc(
					this.getMongoDB().getDb().getCollection("news"));// 改变collection
			BasicDBObject objr = new BasicDBObject();
			BasicDBObject objk = new BasicDBObject();
			objk.put("_id", 0);// 减少mongoDB projection带宽
			newslist = this.getMongoDB().getDbc().find(objr, objk).toArray();// 查询所有新闻聚读信息放入newslist返回
		}
		return newslist;
	}

	// 获取所有Mongdb中存放的站点,所有关于站点的信息放在newsstore collection中
	public List<String> getAllNewsSites() {
		this.getMongoDB().setDbc(
				this.getMongoDB().getDb().getCollection("newsstore"));
		BasicDBObject objr = new BasicDBObject();
		BasicDBObject objk = new BasicDBObject();
		objk.put("_id", 0);// 减少带宽
		this.getMongoDB().setCur(this.getMongoDB().getDbc().find(objr, objk));
		List<String> newname = new ArrayList<String>();
		while (this.getMongoDB().getCur().hasNext()) {
			newname.add((this.getMongoDB().getCur().next().get("name")
					.toString()));
		}
		return newname;
	}

	// 获取用户偏好
	public String getUserPrefer(String uname) {
		String uprefer = "";
		this.getMongoDB().setDbc(
				this.getMongoDB().getDb().getCollection("user"));
		BasicDBObject objr = new BasicDBObject();
		BasicDBObject objk = new BasicDBObject();
		objr.put("uname", uname);
		objk.put("_id", 0);// 减少带宽
		objk.put("uname", 0);// 减少带宽
		objk.put("upwd", 0);// 减少带宽s
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
		objk.put("_id", 0);//减少带宽
		this.getMongoDB().setCur(this.getMongoDB().getDbc().find(objr, objk));
		newslist = this.getMongoDB().getDbc().find(objr, objk).toArray();// 查询所有新闻聚读信息放入newslist返回
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
