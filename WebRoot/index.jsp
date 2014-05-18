<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>聚读</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 网站图标 -->
<link rel="shortcut icon" href="img/icon/favicon.png">
<!-- Bootstrap  http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css-->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- jit -->
<!-- JIT Library File -->
<script language="javascript" type="text/javascript" src="js/jit.js"></script>
<script language="javascript" type="text/javascript"
	src="js/Hypertree.js"></script>
<link type="text/css" href="css/base.css" rel="stylesheet" />
<link type="text/css" href="css/Hypertree.css" rel="stylesheet" />

<!-- Custom styles for this template  http://v3.bootcss.com/examples/jumbotron-narrow/jumbotron-narrow.css-->
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body onload="init();">

	<div class="container">
		<!-- 引入页面头部文件 -->
		<jsp:include page="includePage/header/header.jsp" />
		<!-- 内容体 -->

		<div class="well" align="center">
			<!-- jit -->
			<div id="infovis"></div>
			<div id="log"></div>
			<!-- Button trigger modal -->
			<button class="btn btn-default btn-ms " data-toggle="modal"
				data-target="#myModal" id="loginMe" data-toggle="tooltip"
				title="开始聚读">
				<span class="glyphicon glyphicon-user"></span>&nbsp即刻登录
			</button>
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel"></h4>
						</div>
						<div class="modal-body"><jsp:include
								page="includePage/loginPage/loginModal.jsp" />
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<span>&nbsp</span> <a class="btn btn-ms btn-default"
				href="register.jsp" role="button" id="registerMe"
				data-toggle="tooltip" title="欢迎加入聚读"><span
				class="glyphicon glyphicon-send"></span>&nbsp让我注册</a>
		</div>
		<p></p>
		<!-- 引入footer -->
		<jsp:include page="includePage/footer/footer.jsp" />
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js-->
	<script src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
