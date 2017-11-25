<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>With Dog</title>
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
				<form action="registReview.do" method="POST"
					enctype="multipart/form-data">
					<header>
						<input type="hidden" name="spotId" value="${spot.spotId }">
						<h2 align="left">${spot.spotName }</h2>
						<h2 align="right">
							<input class="btn btn-primary" type="submit" value="평가글 등록" />
						</h2>
					</header>
					<section>
						<input type="hidden" name="writerId" value="${user.userId }">
						<h3 align="left">작성자 | ${user.userId }</h3>
						<h3 align="left">작성일 | ${date }</h3>
						<br>
						<div class="reviews">
							<input class="form-control" id="title" type="text"
								placeholder="제목을 입력해 주세요." name="title" required="required" /><br>
							<textarea class="form-control" id="content" name="content"
								rows="10" cols="40" placeholder="내용을 입력해 주세요."
								required="required"></textarea>
							<br>
							<div class="row" align="left">
								<section>
									<label class="btn btn-info upload-button">이미지 첨부<input
										style="display: none" type="file" id="input_imgs"
										multiple="multiple" />
									</label>
									<div class="imgs_wrap"></div>
								</section>
							</div>
						</div>
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