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

<!--showMap-->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=RQUNwC26q24ETH0hzeGg&submodules=geocoder"></script>
<script type="text/javascript" src="resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/showMap.js"></script>
</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->


	<!-- Main -->
	<div id="main">

		<div class="container">

			<div class="row" style="float: right;">
			<c:set value="spotList.do" var="backPage"></c:set>
				<c:choose>

					<c:when test="${loginUser.userId eq spotDetail.registerId || loginUser.userId eq 'admin'}">
						<a href="modifySpot.do?spotId=${spotDetail.spotId }"><img
							src="resources/img/modify.png" style="width: 25px; height: auto;">
						<h3>수정하기</h3></a>
						
						<a href="removeSpot.do?spotId=${spotDetail.spotId }&backPage=${backPage}"><img
							src="resources/img/delete.png" style="width: 25px; height: auto;">
						<h3>삭제하기</h3></a>
					</c:when>


					<c:otherwise >
						<a
							href="registReport.do?reportTargetId=${spotDetail.spotId}&reportType=spot"><img
							src="resources/img/alarm.png"
							style="width: 25px; height: auto; vertical-align: right;" alt="">
						<h3>신고하기</h3></a>
					</c:otherwise>
				</c:choose>

				<div class="3u"
					style="float: right; margin-right: 30px; width: auto">
					<a href="spotList.do" class="btn_comm btn_submit form-control"
						style="text-align: center;"> <strong style="color: white">장소목록으로</strong></a>
				</div>
			</div>

			<div class="row">
				<section>

					<header>
						<h2 align="left">${spotDetail.spotName }</h2>
					</header>


					<div class="row">
						<section>
							<h3 align="left">분류 | ${spotDetail.spotType }</h3>
							<h3 align="left">주소 | ${spotDetail.spotLocation }</h3>
							<input type="hidden" id="spotAddress"
								value="${spotDetail.spotLocation }"> <a href="#"
								class="image full"> <img
								src="/images/${spotDetail.thumbnail }" style="width: 370px"></a>
						</section>
					</div>

				</section>

				<div id="map" style="width: 63%; height: 470px; margin: 25px"></div>

			</div>

			<section>
				<div style="border: 2px solid; padding: 10px;">

					<h2>장소 소개</h2>
					<h3>${spotDetail.spotInfo }</h3>
				</div>
			</section>

			<section>
				<div class="row">
					<c:forEach var="uploadFile" items="${spotDetail.spotImageList}">
						<div class="4u">
							<section>
								<img class="imgs" src="/images/${uploadFile}" />
							</section>
						</div>
					</c:forEach>
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
							<hr>
						</header>

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
										<th colspan="4" class="text-center">평가글 존재하지 않습니다.</th>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="review" items="${spotDetail.reviewList }">
										<tr>
											<td class="text-center">${review.reviewId }</td>
											<td class="text-center"><a
												href="reviewDetail.do?reviewId=${review.reviewId }&spotId=${spotDetail.spotId}">${review.title }</a></td>
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
			<div class="3u">
				<a href="registReview.do?spotId=${spotDetail.spotId }"
					class="btn_comm btn_submit form-control" style="text-align: center"><strong
					style="color: white">평가글 등록</strong></a>
			</div>

		</div>
	</div>
	<!-- /Footer -->

	<!-- Copyright -->
	<div id="copyright">
		<div class="container">
			Design: <a href="">WITH DOG</a> Images: <a href="">WITH DOG</a> (<a
				href="">CC0</a>)
		</div>
	</div>


</body>
</html>