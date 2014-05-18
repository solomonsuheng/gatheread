package com.gatheread.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gatheread.DAO.PreferSettingDAO;
import com.gatheread.DAO.PreferSettingMongoDAO;

public class PreferSettingServlet extends HttpServlet {
	PreferSettingDAO dao = new PreferSettingMongoDAO();

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
		String uname = (String) request.getSession().getAttribute("uname");
		String uprefer = request.getParameter("uprefer");
		if (dao.setPrefer(uname, uprefer)) {
			dao.setPrefer(uname, uprefer);
			request.getSession().setAttribute("perrMsg", "偏好设置成功");
			response.sendRedirect("logined/preferSetting.jsp");
		} else {
			request.getSession().setAttribute("perrMsg", "请重新设置偏好");
			response.sendRedirect("logined/preferSetting.jsp");
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
