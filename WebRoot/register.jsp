<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>聚读</title>
<link rel="shortcut icon" href="img/icon/favicon.png">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap
http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css-->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<!-- 引入页面头部文件 -->
		<jsp:include page="includePage/header/header.jsp" />
		<!-- 内容体 -->
		<div class="well" align="center">
			<form class="form-signin" role="form" action="registerServlet"
				method="post">
				<h1 class="form-signin-heading">聚读</h1>
				<h3>
					<span class="label label-warning">${sessionScope.errMsg}</span>
				</h3>
				<input type="text" class="form-control" placeholder="用户名"
					required="" autofocus="" name="uname"> <input
					type="text" class="form-control" placeholder="偏好" required=""
					autofocus="" name="uprefer" id="preferID">
				<div class="well">

					<a class="btn btn-xs btn-default" role="button"
						onclick="document.getElementById('preferID').value='ThomsonReuters'">汤森路透</a>
					<a class="btn btn-xs btn-default" role="button"
						onclick="document.getElementById('preferID').value='XinhuaNewsAgency'">新华社</a>
					<a class="btn btn-xs btn-default" role="button"
						onclick="document.getElementById('preferID').value='NewWeekly'">新周刊</a>
				</div>
				<input type="password" class="form-control" placeholder="密码"
					required="" name="upwd">
				<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
			</form>
		</div>
		<!-- 内容体结束 -->

		<!-- 引入footer -->
		<jsp:include page="includePage/footer/footer.jsp" />
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js-->
	<script src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
