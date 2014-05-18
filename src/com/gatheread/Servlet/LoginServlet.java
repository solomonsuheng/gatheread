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
 * @Description: ��¼��̨Servlet,��֤��¼
 * @author ���պ�
 * @date 2014-5-14 ����4:41:54
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
			// ���ڸ��û�
			request.getSession().setAttribute("uname", uname);
			response.sendRedirect("readServlet");//��ת����ȡ���о۶�ҳ��
		}else{
			request.getSession().setAttribute("errMsg", "�û��������벻��ȷ");
			response.sendRedirect("login.jsp");//��ת����ȡ���о۶�ҳ��
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
