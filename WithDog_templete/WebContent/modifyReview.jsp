<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<form action="modifyReview.do" method="POST">
			<input type="hidden" name="reviewId" value="${review.reviewId }">
			<input type="hidden" name="spotId" value="${spot.spotId }">
				<header>
					<h2 align="left">${spot.spotName }</h2>
					<h2 align="right">
						<input class="btn btn-primary" type="submit" value="평가글 수정" />
					</h2>
				</header>
				<section>
					<h3 align="left">작성자 | ${review.writerId }</h3>
					<h3 align="left">작성일 | ${review.registDate }</h3>
					<br>
						<div class="reviews">
							<textarea required="required" class="form-control" id="title" name="title">${review.title }</textarea><br>
							<textarea required="required" class="form-control" id="content" name="content" rows="10" cols="40">${review.content }</textarea>
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