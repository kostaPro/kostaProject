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
<title>WithDog_eventDetail</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<!--화면 정렬-->
<link rel='stylesheet' id='bootstrap-css'
	href='//netdna.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css'
	type='text/css' media='all' />

<!--필수항목 아이콘-->
<link rel='stylesheet' id='font-awesome-css'
	href='//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'
	type='text/css' media='all' />

<!--화면 전체 디자인-->
<link rel='stylesheet' id='style-css'
	href='http://www.sweetspot.co.kr/wp-content/themes/realty-child/style.css'
	type='text/css' media='all' />
<link rel="stylesheet" href="resources/css/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />
</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->


	<!-- Main -->
	<div id="main">

		<div class="container">
			<div class="row">

				<section>
					<header>
						<h2 align="left">${meetingDetail.meetingName }</h2>
					</header>
					<div class="row">
						<section>
							<h3 align="left">모임 일자 | <fmt:formatDate value="${meetingDetail.meetingDate}" pattern="yyyy-MM-dd" /></h3>
							<!-- 왜이러시죠 -->
							<h3 align="left">장소 |</h3>
							<h3 align="left">모임 목적 | ${meetingDetail.meetingPurpose}</h3>
							<hr>
							<c:forEach var="mImage" items="${ImageList}">
								<div class="4u">
									<section>
										<img class="imgs" src="/images/${mImage}" />
									</section>
								</div>
							</c:forEach>

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
					<table class="table table-striped table-bordered table-hover">

						<colgroup>
							<col width="800" />
							<col width="300" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">참여 목록</th>
								<th class="text-center">${joinList}</th>
							</tr>
						</thead>


					</table>
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
							<h2>Comment List</h2>
							<hr>
						</header>

					</section>
				</div>
			</div>

			<div class="row">
				<div class="15u">


					<table class="table table-striped table-bordered table-hover">
						
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