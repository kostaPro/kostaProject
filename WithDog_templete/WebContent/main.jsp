
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
<title>Welcome To WithDog</title>

<!--화면 전체 디자인-->
<link rel="stylesheet" href="resources/css/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />

<!--버튼 디테일-->
<link rel='stylesheet' id='style-css'
	href='http://www.sweetspot.co.kr/wp-content/themes/realty-child/style.css'
	type='text/css' media='all' />

<!--이미지 슬라이드를 위한 기본파일-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<!--이미지슬라이드-->
<script type="text/javascript" src="resources/js/imageSlider.js"></script>

</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->


	<!-- Main -->
	<div id="main">

		<div class="container">
			<section>
				<header>
					<h2>
						<a href="eventList.do">Event List</a>
					</h2>
				</header>

				<div class="slideWrap">
					<div id="eventSlider" class="slider">
						<c:forEach var="event" items="${eventList }">
							<div class="slide">
								<img src="/images/${event.eventImage}">
								<p style="font-size: 35px; padding: 5px">
									<strong>${event.eventName }</strong>
								</p>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</div>
	</div>
	<!-- /Main -->

	<!-- Footer -->
	<div id="meetingWrap">
		<div class="container">
			<section>

				<form action="main.do" method="post">
					<div class="row" style="padding-top: 20px">
						<header>
							<h2>
								<a href="meetingList.do">[Today] Meeting List</a>
							</h2>
						</header>

						<div class="3u">
							<select id="spotLocation" name="mLocation">
								<option value="">지역을 선택해주세요.</option>
								<option value="서울">서울특별시</option>
								<option value="경기">경기도</option>
								<option value="인천">인천광역시</option>
								<option value="강원">강원도</option>
								<option value="부산">부산광역시</option>
								<option value="경남">경상남도</option>
								<option value="전남">전라남도</option>
								<option value="전북">전라북도</option>
								<option value="경북">경상북도</option>
								<option value="충남">충청남도</option>
								<option value="충북">충청북도</option>
								<option value="제주">제주특별시</option>
							</select>
						</div>

						<div class="3u">
							<input type="submit" value="search"
								class="btn btn-primary btn-block form-control" id="search_btn"
								style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;"
								onclick="">
						</div>
					</div>

				</form>
				<div class="row">
					<div class="15u">
						<table class="table table-striped table-bordered table-hover">
							<colgroup>
								<col width="400" />
								<col width="800" />
								<col width="300" />
								<col width="400" />
							</colgroup>
							<thead>
								<tr>
									<th class="text-center">모임 명</th>
									<th class="text-center">모임 일자</th>
									<th class="text-center">모임 시간</th>
									<th class="text-center">주최자</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty meetingList }">
										<tr>
											<th colspan="4 " class="text-center">모임이 존재하지 않습니다.</th>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="meetingList" items="${meetingList }">
											<tr>
												<td class="text-center"><a
													href="meetingDetail.do?meetingId=${meetingList.meetingId }">${meetingList.meetingName }</a></td>
												<td class="text-center"><fmt:formatDate
														value="${meetingList.meetingDate}" pattern="yyyy-MM-dd" /></td>
												<td class="text-center">${meetingList.meetingTime }시</td>
												<td class="text-center">${meetingList.hostId }</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>

				<div class="3u">
					<a href="registMeeting.do" class="btn_comm btn_submit form-control"
						style="text-align: center"><strong style="color: white">모임
							등록</strong></a>
				</div>
				
				<div class="row">
					<section>
						<div class="4u">
							<iframe width="1180" height="600"
								src="http://withdog.dothome.co.kr/"></iframe>
						</div>
					</section>
				</div>

			</section>
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