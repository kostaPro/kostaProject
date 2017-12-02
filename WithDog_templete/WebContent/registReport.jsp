<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>WithDog_RegistReport</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
<link rel="stylesheet" href="resources/css/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />
<script type="text/javascript" src="resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/image.js"></script>
</head>
<body class="homepage">

	<!-- Header -->
	<div id="header">
		<div class="container">

			<!-- Logo -->
			<div id="logo">
				<h1>
					<a href="#">WITH DOG</a>
				</h1>
			</div>
		</div>
		<div id="nav-wrapper" class="container">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li class="active"><a href="index.html">Home</a></li>
					<li><a href="left-sidebar.html">Left Sidebar</a></li>
					<li><a href="right-sidebar.html">Right Sidebar</a></li>
					<li><a href="no-sidebar.html">No Sidebar</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
			<div id="banner">
				<a href="#" class="image featured"><img
					src="resources/img/pics11.jpg" alt=""></a>
			</div>
		</div>
	</div>
	<!-- Header -->


	<!-- Main -->
	<div id="main">
		<div class="container">
			<section>
				<form action="registReport.do" method="POST">
				<input type="hidden" name="reportType" value="${reportType }">
				<input type="hidden" name="reportTargetId" value="${reportTargetId }">
				<input type="hidden" name="userId" value="${userId}">
					<header>

						<h2 align="left">신고 등록</h2>

					</header>

					<section>
						
						<h3 align="left">신고자 | ${userId }</h3>
						<h3 align="left">신고구분 |${reportType }</h3>
						<h3 align="left">신고대상 |${reportTargetId }</h3>
						<br> <input type="text" class="form-control" id="reportContent" name="reportContent" placeholder="신고 사유를 입력해 주세요." /> <br>
						<h2 align="right">
							<input class="btn btn-primary" type="submit" value="신고 등록" />
						</h2>

					</section>
				</form>
			</section>
		</div>
	</div>
	<!-- /Main -->

	<!-- Copyright -->
	<div id="copyright">
		<div class="container">
			Design: <a href="">WITH DOG</a> Images: <a href="">WITH DOG</a> (<a
				href="">CC0</a>)
		</div>
	</div>
</body>
</html>