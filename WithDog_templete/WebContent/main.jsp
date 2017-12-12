
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

<!--화면 정렬-->
<link rel='stylesheet' id='bootstrap-css'
	href='//netdna.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css'
	type='text/css' media='all' />

<!--필수항목 아이콘-->
<link rel='stylesheet' id='font-awesome-css'
	href='//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'
	type='text/css' media='all' />

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

<!--showMap-->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=RQUNwC26q24ETH0hzeGg&submodules=geocoder"></script>
<script type="text/javascript"
	src="resources/js/markMultipleMeetingSpot.js"></script>

<!--js로 meeting객체리스트 넘기기-->
<script type="text/javascript">
	$(document).ready(function() {
		var meetings = new Array();

		<c:forEach var="meeting" items="${meetingList }">

		var meetingObj = new Object();

		meetingObj.meetingName = "${meeting.meetingName}";
		meetingObj.meetingId = "${meeting.meetingId}";
		meetingObj.meetingSpot = "${meeting.meetingSpot.spotLocation}";

		meetings.push(meetingObj);
		</c:forEach>

		markMultipleMeetingSpot(JSON.stringify(meetings));

	})
</script>

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
								<a href="eventDetail.do?eventId=${event.eventId }"><img
									src="/images/${event.eventImage}" style="width: 500px; height:750px"></a>
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
	<div id="subWrap">
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
							<input type="text" placeholder="주소를 입력해주세요" name="spotLocation"
								id="spotLocation" class="form-control" />
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
							<col width="400" />
							<col width="150" />
							<col width="400" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">모임 명</th>
								<th class="text-center">모임 장소</th>
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
											<td class="text-center">${meetingList.meetingSpot.spotLocation }</td>
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

					<div id="map" style="width: 100%; height: 400px;"></div>

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