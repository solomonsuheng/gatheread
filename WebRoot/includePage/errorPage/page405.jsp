<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


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
<!-- Custom styles for this template -->
<link href="/gatheread/css/jumbotron-narrow.css" rel="stylesheet">
<link href="/gatheread/css/signin.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<%@include file="../header/header.jsp"%>


		<div class="jumbotron">
			<h1 class="form-signin-heading">聚读</h1>
			<p class="lead">分享全人类的资讯</p>
			<a class="btn btn-lg btn-default" href="/gatheread/index.jsp" role="button">放弃越链,快乐的玩耍</a>
		</div>
		<div class="alert alert-danger" align="center">Oopssss.....小伙伴们请不要尝试越链</div>
		<div class="progress progress-striped active">
			<div class="progress-bar" role="progressbar" aria-valuenow="100"
				aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
		</div>
		<%@include file="../footer/footer.jsp"%>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/gatheread/js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/gatheread/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
