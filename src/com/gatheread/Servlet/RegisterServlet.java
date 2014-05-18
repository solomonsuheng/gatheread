package com.gatheread.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gatheread.DAO.LoginDAO;
import com.gatheread.DAO.LoginMongoDAO;
import com.gatheread.DAO.RegisterDAO;
import com.gatheread.DAO.RegisterMongoDAO;

/**
 * @ClassName: RegisterServlet
 * @Description: 注册用户Servlet
 * @author 葛苏恒
 * @date 2014-5-14 下午7:07:56
 */
public class RegisterServlet extends HttpServlet {
	private RegisterDAO dao = new RegisterMongoDAO();

	/**
	 * @return dao
	 */
	public RegisterDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            要设置的 dao
	 */
	public void setDao(RegisterDAO dao) {
		this.dao = dao;
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
		String uprefer = request.getParameter("uprefer");
		if (dao.saveUser(uname, upwd, uprefer)) {
			request.getSession().setAttribute("uname", uname);// 注册成功,将用户名放入session中
			response.sendRedirect("readServlet");
		} else {
			request.getSession().setAttribute("errMsg", "请尝试其他用户名");
			response.sendRedirect("register.jsp");
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
