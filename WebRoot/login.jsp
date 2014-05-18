<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>新闻聚读</title>
<link rel="shortcut icon" href="img/icon/favicon.png">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- bootstrap head -->
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!-- bootstrap引用 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<%@include file="includePage/header/header.jsp"%>
		<div class="jumbotron">
			<form class="form-signin" role="form" action="loginServlet"
				method="post">
				<h1 class="form-signin-heading">聚读</h1>
				<h3>
					<span class="label label-warning">${sessionScope.errMsg}</span>
				</h3>

				<input type="text" class="form-control" placeholder="用户名"
					required="" autofocus="" name="uname"> <input
					type="password" class="form-control" placeholder="密码" quired=""
					name="upwd">
				<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
			</form>
		</div>
		<div class="progress progress-striped active">
			<div class="progress-bar" role="progressbar" aria-valuenow="100"
				aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
		</div>
		<%@include file="includePage/footer/footer.jsp"%>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
