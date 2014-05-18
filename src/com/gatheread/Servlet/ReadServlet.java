package com.gatheread.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gatheread.DAO.ReadDAO;
import com.gatheread.DAO.ReadMongoDAO;

/**
 * @ClassName: ReadServlet
 * @Description: 获取聚读Servlet
 * @author 葛苏恒
 * @date 2014-5-15 上午8:26:28
 */
public class ReadServlet extends HttpServlet {
	private ReadDAO dao = new ReadMongoDAO();

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
		dao.destroy();
	}

	/*
	 * (非 Javadoc) <p>Title: doGet</p> <p>Description: </p>
	 * 
	 * @param req
	 * 
	 * @param resp
	 * 
	 * @throws ServletException
	 * 
	 * @throws IOException
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String uprefer = request.getParameter("uprefer");// 从前台获取uprefer参数,标识是否偏好聚读
		String uname = (String) request.getSession().getAttribute("uname");
		if ("prefer".equals(uprefer)) {
			// 使用偏好聚读
			List newslist = dao.getNewsByPrefer(uname);
			request.getSession().setAttribute("newslist", newslist);
			response.sendRedirect("logined/logined.jsp");
		} else {
			List newslist = dao.getAllNews();
			request.getSession().setAttribute("newslist", newslist);
			response.sendRedirect("logined/logined.jsp");
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		dao.init();
	}

}
