<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>

<title>聚读</title>
<link rel="shortcut icon" href="/gatheread/img/icon/favicon.png">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- bootstrap head -->
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!-- bootstrap引用 -->
<link rel="stylesheet" href="/gatheread/bootstrap/css/bootstrap.min.css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<!-- 网站图标 -->
<!-- Custom styles for this template -->
<link href="/gatheread/css/jumbotron-narrow.css" rel="stylesheet">
<link href="/gatheread/css/signin.css" rel="stylesheet">


</head>

<body>

	<div class="container">
		<%@include file="../includePage/header/header.jsp"%>
		<div class="userinfo" align="right">
			<span class="label label-primary">您好,${sessionScope.uname}</span> <a
				class="btn btn-xs btn-success" role="button"
				href="/gatheread/readServlet?uprefer=prefer">偏好聚读</a>
			<!-- 下拉式按钮 -->
			<div class="btn-group">
				<button type="button" class="btn btn-xs btn-info dropdown-toggle"
					data-toggle="dropdown">
					账号<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" style="text-align: left;">
					<li><a href="../includePage/functionPage/clear.jsp">注销</a>
					</li>
				</ul>
			</div>
		</div>
		<p></p>

		<div class="well" align="center">
			<form class="form-signin" role="form"
				action="/gatheread/preferSettingServlet" method="post">
				<h2 class="form-signin-heading">
					<span class="glyphicon glyphicon-wrench"></span>
				</h2>
				<h3>
					<span class="label label-warning">${sessionScope.perrMsg}</span>
				</h3>
				<input type="text" class="form-control" placeholder="偏好" required=""
					autofocus="" name="uprefer" id="preferID">
				<p></p>
				<div class="well">

					<a class="btn btn-xs btn-default" role="button"
						onclick="document.getElementById('preferID').value='ThomsonReuters'">汤森路透</a>
					<a class="btn btn-xs btn-default" role="button"
						onclick="document.getElementById('preferID').value='XinhuaNewsAgency'">新华社</a>
					<a class="btn btn-xs btn-default" role="button"
						onclick="document.getElementById('preferID').value='NewWeekly'">新周刊</a>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">设置偏好</button>
			</form>
		</div>

		<div class="progress progress-striped active">
			<div class="progress-bar" role="progressbar" aria-valuenow="100"
				aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
		</div>
		<%@include file="../includePage/footer/footer.jsp"%>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/gatheread/js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/gatheread/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
