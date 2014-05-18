<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>聚读</title>
<link rel="shortcut icon" href="/gatheread/img/icon/favicon.png">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap
http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css-->
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<!-- Bootstrap core CSS -->
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="../css/jumbotron-narrow.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<!-- gototop导入的Js文件 -->
<script type="text/javascript" src="/gatheread/js/jquery.js"></script>
<script type="text/javascript" src="/gatheread/js/gototop.js"></script>
<!-- gototop导入的css文件 -->
<link rel="stylesheet" href="/gatheread/css/gototop.css" />
<link rel="stylesheet" href="/gatheread/css/pin.css" />

</head>
<body>
	<div class="container">
		<%@include file="../includePage/header/header.jsp"%>
		<div class="userinfo" align="right" style="margin-top: -20px;">
			<span class="label label-primary">您好,${sessionScope.uname}</span> <a
				class="btn btn-xs btn-success" role="button" href="../readServlet">所有聚读</a>
			<!-- 使用的是get方法，servlet后跟一个参数标识类型，默认没有参数标识获取所有的聚读信息 -->
			<a class="btn btn-xs btn-success" role="button"
				href="../readServlet?uprefer=prefer">偏好聚读</a>
			<!-- 下拉式按钮 -->
			<div class="btn-group">
				<button type="button" class="btn btn-xs btn-info dropdown-toggle"
					data-toggle="dropdown">
					账号<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" style="text-align: left;">
					<li><a href="preferSetting.jsp">偏好设置</a></li>
					<li class="divider"></li>
					<li><a href="../includePage/functionPage/clear.jsp">注销</a></li>
				</ul>
			</div>
		</div>
		<p></p>


		<div id="wrapper">
			<div id="columns">
				<c:forEach var="item" items="${newslist}">
					<!-- 新闻整体块 -->
					<div class="pin">
						<div style="text-align: center;">
							<c:choose>
								<c:when test="${item.nweb=='ThomsonReuters' }">
									<img src="../img/imgSrc/tslt.png" alt="汤森路透"
										class="img-rounded">
								</c:when>
								<c:when test="${item.nweb=='NewWeekly' }">
									<img src="../img/imgSrc/xzk.png" alt="新周刊" class="img-rounded">
								</c:when>
								<c:when test="${item.nweb=='XinhuaNewsAgency' }">
									<img src="../img/imgSrc/xhs.png" alt="新华社" class="img-rounded">
								</c:when>
							</c:choose>
						</div>
						<h4>
							<c:out value="${ item.ntitle}" />
						</h4>
						<h5>
							<c:out value="${ item.ncontent}" />
						</h5>
						<p align="center">
							<a href=<c:out value="${ item.nlink}" /> target="_blank"
								class="btn btn-primary" role="button"><span
								class="glyphicon glyphicon-log-in"></span>&nbsp&nbsp深度阅读</a>
						</p>

					</div>
				</c:forEach>
			</div>
		</div>






		<!-- gototop按钮 -->
		<div id="share">
			<a id="totop" title="">返回顶部</a>
			<!-- <a href="#" target="_blank"
				class="sina">新浪微博</a> <a href="#" target="_blank" class="tencent">腾讯微博</a> -->
		</div>




		<%@include file="../includePage/footer/footer.jsp"%>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js-->
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
