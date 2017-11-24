<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>With Dog</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="resources/css/reviewStyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'
	href='https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css'>
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="resources/js/skel.min.js"></script>
<script src="resources/js/skel-panels.min.js"></script>
<script src="resources/js/init.js"></script>
<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js'></script>
<script
	src='https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/fd8bd86dd78f789fb742798b7d49aba0a957af62/src/js/bootstrap-datetimepicker.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/moment-timezone/0.4.0/moment-timezone-with-data-2010-2020.min.js'></script>
<link rel="stylesheet" href="resources/css/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />

</head>
<body class="homepage">

	<!-- Header -->
	<div id="header">
		<div class="container">

			<!-- Logo -->
			<div id="logo">
				<h1>
					<a href="#">Elemental</a>
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
				<header>
					<h2 align="left">장소명</h2>
					<h2 align="right">
						<button class="btn btn-primary" type="button">장소 신고</button>
					</h2>
				</header>

				<section>
					<div class="row">
						<section>
							<h1>작성자 :</h1>
						</section>
						<section>
							<h1>jakook</h1>
						</section>
					</div>
				</section>

				<section>
					<div class="row">
						<section>
							<h1>작성일 :</h1>
						</section>
						<section>
							<input type='text' class="form-control" id='datetimepicker' />
							<script src="resources/js/date.js"></script>
						</section>
					</div>
				</section>
				<section>
					<div class="row">
						<section>
							<h1>제목 :</h1>
						</section>
						<section>
							<h1>선유도 공원</h1>
						</section>
					</div>
				</section>
				<section>
					<div class="row">
						<section>
							<h1>내용 :</h1>
						</section>
						<section>
							<h1>좋아요.</h1>
						</section>
					</div>
				</section>

				<div class="row">
					<div class="4u">
						<section>
							<a href="#" class="image full"><img
								src="resources/img/pics01.jpg" alt=""></a>
						</section>
					</div>
					<div class="4u">
						<section>
							<a href="#" class="image full"><img
								src="resources/img/pics02.jpg" alt=""></a>
						</section>
					</div>
					<div class="4u">
						<section>
							<a href="#" class="image full"><img
								src="resources/img/pics03.jpg" alt=""></a>
						</section>
					</div>
				</div>

				<div class="section">

					<div class="reviews">
						<h3 align="left" id="name">작성자</h3>
						<br>
						<textarea class="form-control" id="review" type="text" rows="4"
							cols="40" placeholder="댓글을 작성해 주세요."></textarea>
						<button class="btn btn-primary" type="button"
							onclick="getComments()">댓글 등록</button>
					</div>
				</div>
				<div class="append"></div>
				<script
					src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
				<script
					src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>

				<script src="resources/js/index.js"></script>
			</section>
		</div>
	</div>
	<!-- /Main -->

	<!-- Copyright -->
	<div id="copyright">
		<div class="container">
			Design: <a href="http://templated.co">TEMPLATED</a> Images: <a
				href="http://unsplash.com">Unsplash</a> (<a
				href="http://unsplash.com/cc0">CC0</a>)
		</div>
	</div>


</body>
</html>