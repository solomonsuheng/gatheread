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
<link href="/gatheread/css/jumbotron-narrow.css" rel="stylesheet">
<link href="/gatheread/css/signin.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<%@include file="../header/header.jsp"%>
		<div class="l">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<span class="glyphicon glyphicon-book"></span>&nbspEdu
				</div>
				<div class="panel-body">
					<ul class="list-group">
						<li class="list-group-item">University Education</li>
					</ul>
				</div>
				<!-- Default panel contents -->
				<div class="panel-heading">
					<span class="glyphicon glyphicon-heart-empty"></span>&nbspOpen Source
				</div>
				<div class="panel-body">
					<ul class="list-group">
						<li class="list-group-item"><img
							src="/gatheread/img/imgSrc/bfavicon.png" />&nbsp&nbsp<span
							class='btn btn-xs btn-info' role='button'>最初是由就职于Twitter的一个设计师和一个工程师创造的,现在已成为世界上最流行的前端开发框架和开源项目</span>
						</li>
						<li class="list-group-item"><img
							src="/gatheread/img/imgSrc/mongodb.png" />&nbsp&nbsp<span
							class='btn btn-xs btn-info' role='button'>MongoDB
								基于分布式文件存储的数据库 Power by MongoDB.Inc</span></li>
					</ul>
				</div>

			</div>
		</div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<script src="/gatheread/js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/gatheread/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
