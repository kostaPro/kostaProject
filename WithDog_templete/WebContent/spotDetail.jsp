<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<!--
	Elemental by TEMPLATED
    templated.co @templatedco
    Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>WithDog_spotDetail</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="resources/js/skel.min.js"></script>
<script src="resources/js/skel-panels.min.js"></script>
<script src="resources/js/init.js"></script>
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
			<div class="row">



				<section>
					<header>
						<h2 align="left">선유도 공원</h2>
					</header>
					<div class="row">
						<section>
							<h3 align="left">분류 | 공원</h3>
							<h3 align="left">주소 | 서울 특별시 영등포구 선유로343</h3>
							<hr>
							<a href="#" class="image full"><img
								src="resources/img/pics01.jpg" alt=""></a>

						</section>
					</div>

				</section>

				<section>
					<div class="4u">
						<iframe width="760" height="500"
							src="http://withdog.dothome.co.kr/"></iframe>
					</div>
				</section>

			</div>

			<section>
				<div style="border: 2px solid; padding: 10px;">

					<h2>장소 소개</h2>
					<h3>Pellentesque tristique ante ut risus. Quisque dictum.
						Integer sagittis convallis, rutrum elementum congue, nibh.
						Suspendisse dictum porta lectus.</h3>
				</div>
			</section>

			<hr>
			<section>
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
			</section>
		</div>
	</div>
	<!-- /Main -->

	<!-- Footer -->
	<div id="footer">
		<div class="container">
			<div class="row half">
				<div class="3u">
					<section>
						<header>
							<h2>Review List</h2>
						</header>
						<hr>

					</section>
				</div>
			</div>

			<div class="row">
				<div class="15u">


					<table class="table table-striped table-bordered table-hover">
						<colgroup>
							<col width="80" />
							<col width="500" />
							<col width="300" />
							<col width="300" />
							<col width="80" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">번호</th>
								<th class="text-center">제목</th>
								<th class="text-center">작성일</th>
								<th class="text-center">작성자</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty spotDetail.reviewList }">
									<tr>
										<th colspan="5" class="text-center">평가글 존재하지 않습니다.</th>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="review" items="${spotDetail.reviewList }">
										<tr>
											<td class="text-center">${review.reviewId }</td>
											<td class="text-center"><a
												href="registReview.do?spotId=${review.spotId }">${review.title }</a></td>
											<td class="text-center"><fmt:formatDate
													value="${review.registDate }" pattern="yyyy-MM-dd" /></td>
											<td class="text-center">${review.writerId }</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>


				</div>

			</div>
		</div>
	</div>
	<!-- /Footer -->

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