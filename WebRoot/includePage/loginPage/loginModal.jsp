<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="css/signin.css" rel="stylesheet">
<!-- session中已经存在了用户，则跳转到首页自动跳转到已经登陆的页面 -->
<c:if test="${empty sessionScope.uname }">
	<form class="form-signin" role="form" action="loginServlet"
		method="post">
		<input type="text" class="form-control" placeholder="用户名" required=""
			autofocus="" name="uname"> <input type="password"
			class="form-control" placeholder="密码" quired="" name="upwd">
		<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
	</form>
</c:if>
<c:if test="${not empty sessionScope.uname }">
	<a href='logined/logined.jsp'> <span class='btn btn-lg btn-success'
		role='button'><span class='glyphicon glyphicon-user'></span>&nbsp登录:${uname
			}</span> </a>
	<a href='includePage/functionPage/clear.jsp'> <span class='btn btn-lg btn-success'
		role='button'><span class='glyphicon glyphicon-log-out'></span>&nbsp注销:${uname
			}</span> </a>
</c:if>
