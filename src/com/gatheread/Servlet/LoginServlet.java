package com.gatheread.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gatheread.DAO.LoginDAO;
import com.gatheread.DAO.LoginMongoDAO;

/**
 * @ClassName: LoginServlet
 * @Description: 登录后台Servlet,验证登录
 * @author 葛苏恒
 * @date 2014-5-14 下午4:41:54
 */
public class LoginServlet extends HttpServlet {
	private LoginDAO dao = new LoginMongoDAO();

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
		dao.destroy();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		if (this.getDao().isByNameAndPwd(uname, upwd)) {
			// 存在该用户
			request.getSession().setAttribute("uname", uname);
			response.sendRedirect("readServlet");//跳转到获取所有聚读页面
		}else{
			request.getSession().setAttribute("errMsg", "用户名或密码不正确");
			response.sendRedirect("login.jsp");//跳转到获取所有聚读页面
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

	/**
	 * @return dao
	 */
	public LoginDAO getDao() {
		return dao;
	}

}
