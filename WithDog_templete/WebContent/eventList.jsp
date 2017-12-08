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
<title>WithDog_eventList</title>
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

<!--데이트피커/팝업/미리보기를 위란 기본 파일-->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />

<!--데이트피커-->
<script type="text/javascript" src="resources/js/eventDatepicker.js"></script>

<!--showMap-->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=RQUNwC26q24ETH0hzeGg&submodules=geocoder"></script>
<script type="text/javascript" src="resources/js/markMultipleSpot.js"></script>

<!--js로 event객체리스트 넘기기-->
<script type="text/javascript" >
	var events = new Array();
	
	<c:forEach var="event" items="${eventList }">
	
		var eventObj = new Object();
	
		eventObj.eventName = "${event.eventName}";
		eventObj.eventId = "${event.eventId}";
		eventObj.eventSpot = "${event.eventSpot.spotLocation}";

		events.push(eventObj);
	</c:forEach>
	
	markMultipleSpot(JSON.stringify(events));
</script>
</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->


	<!-- Main -->
	<div id="main">

		<div class="container">
			<form class="property-search-form" action="eventList.do"
				method="post">

				<div class="row">
					<p>
						<input type="text" id="datepicker" name="date"
							value="시작일을 선택해주세요.">
					</p>

					<div class="3u">

						<select name="spotLocation" id="spotLocation" class="form-control">
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
							style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">
					</div>

				</div>

				<div id="map" style="width: 100%; height: 400px;"></div>

			</form>

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
							<h2>EventList</h2>

						</header>

					</section>
				</div>
			</div>

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
								<th class="text-center">이벤트 명</th>
								<th class="text-center">시작일</th>
								<th class="text-center">종료일</th>
								<th class="text-center">이벤트 장소</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty eventList }">
									<tr>
										<th colspan="4 " class="text-center">이벤트가 존재하지 않습니다.</th>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="eventList" items="${eventList }">
										<tr>
											<td class="text-center"><a
												href="eventDetail.do?eventId=${eventList.eventId }">${eventList.eventName }</a></td>
											<td class="text-center"><fmt:formatDate
													value="${eventList.openDate}" pattern="yyyy-MM-dd" /></td>
											<td class="text-center"><fmt:formatDate
													value="${eventList.closeDate}" pattern="yyyy-MM-dd" /></td>
											<td class="text-center">${eventList.eventSpot.spotLocation }</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>


				</div>
			</div>
			<div class="3u" style="float: right">
				<a href="registEvent.do" class="btn_comm btn_submit form-control"
					style="text-align: center"><strong style="color: white">이벤트
						등록</strong></a>
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
