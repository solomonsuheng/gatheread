<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
//清除Session中所有数据
<%
	request.getSession().invalidate();
	response.sendRedirect("../../index.jsp");
%>