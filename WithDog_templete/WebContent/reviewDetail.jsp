<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<header>
					<h2 align="left">선유도 공원</h2>

					<h2 align="right">
						<button class="btn btn-primary" type="button">평가글 삭제</button>
						<button class="btn btn-primary" type="button">평가글 신고</button>
					</h2>
				</header>
				<section>
					<h3 align="left">작성자 | jakook</h3>
					<h3 align="left">작성일 | 2017/11/22</h3>
					<br>
					<div class="row">
						<h3 align="left">제목 | 선유도 공원 평가글입니다.</h3>
					</div>
				</section>
				<div class="row">
					<c:forEach var="uploadFile" items="${uploadFileList}">
						<div class="4u">
							<section>
								<a href="#" class="image full"><img
									src="/images/${uploadFile}" /></a>
							</section>
						</div>
					</c:forEach>
				</div>
				<section>
					<div class="row">
						<section>
							<h3 align="left">[내용]</h3>
							<h3 align="left">Consectetuer adipiscing elit. Nam pede
								erat, porta eu, lobortis eget, tempus et, tellus. Etiam neque.
								Vivamus consequat lorem at nisl. Nullam non wisi a sem semper
								eleifend. Donec mattis libero eget urna. Duis pretium velit ac
								mauris.Consectetuer adipiscing elit. Nam pede erat, porta eu,
								lobortis eget, tempus et, tellus. Etiam neque. Vivamus consequat
								lorem at nisl. Nullam non wisi a sem semper eleifend. Donec
								mattis libero eget urna. Duis pretium velit ac mauris.</h3>
						</section>
					</div>
				</section>
				<!-- foreach ======================================================================================= -->
				<table class="table" style="font-size: 14px; padding: 20px;">
					<tr>
						<td class="text-left"><strong>jakook4013</strong></td>
						<td class="text-left">eleifend. Donec mattis libero eget
							urna. Duis pretium velit ac mauris.Consectetuer adipiscing elit.
							Nam pede erat, porta eu, lobortis eget, tempus et, tellus. Etiam
							neque. Vivamus consequat lorem at nisl. Nullam non wisi a sem
							semper eleifend. Donec mattis libero eget urna. Duis pretium
							velit ac mauris.</td>
						<td>2017/11/22<a href=""> 수정 </a> <a href="">삭제</a></td>

					</tr>
					<tr>
					</tr>
				</table>
			</section>
		</div>
		<div class="section">
			<div class="reviews">
				<form action="${ctx }/comment/regist.do">
					<input type="hidden" name="articleId" value="${article.articleId }">
					<textarea class="form-control" id="review" rows="4" cols="40"
						placeholder="댓글을 작성해 주세요." name="comments"></textarea>
					<input type="submit" class="btn btn-primary" value="댓글 등록">
				</form>
			</div>
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