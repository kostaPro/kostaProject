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
<title>WithDog_meetingList</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
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

<!--데이트피커를 위란 기본 파일-->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!--데이트피커-->
<script type="text/javascript" src="resources/js/eventDatepicker.js"></script>


<style>
.pp input,
.pp select { float:left; margin:0 10px;  width:33%;}
.pp { content:""; display:block; clear:both;}

.pp input:last-of-type { width:100px; color:#fff; background:#43becc; border:1px solid #43becc;}
.text-center{ width:100px;}
.text-ss{ width:10%; text-align: center;}
</style>

</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->

	<!-- Main -->
	<div id="main">

		<div class="container">
			<div class="row">
		<%@include file="myPage_user.jsp"%>
			<div id="content" class="9u skel-cell-important">
					<section>
						<section>
							<header>
								<font size="6" color="#000000"><b>주최 모임</b></font>
								<hr>
							</header>

						</section>



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
									<th class="text-center" width="30">모임 일자</th>
									<th class="text-center">모임 시간</th>
									<th class="text-ss">수정</th>
									<th class="text-ss">삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty hostList }">
										<tr>
											<th colspan="4 " class="text-center">모임이 존재하지 않습니다.</th>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="hostMeeting" items="${hostList }">
											<tr>
												<td class="text-center"><a
													href="meetingDetail.do?meetingId=${hostMeeting.meetingId }">${hostMeeting.meetingName }</a></td>
												<td class="text-center"><fmt:formatDate value="${hostMeeting.meetingDate}" pattern="yyyy-MM-dd" /></td>
												<td class="text-center">${hostMeeting.meetingTime }시</td>
												<td><a href="myModifyMeeting.do?meetingId=${hostMeeting.meetingId }"><img src="resources/img/modify.png" style="width: 25px; height: auto; vertical-align:right;" alt=""></a></td>
												<td><a href="myRemoveMeeting.do?meetingId=${hostMeeting.meetingId }"><img src="resources/img/delete.png" style="width: 25px; height: auto; vertical-align:right;" alt=""></a></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>


			</section>
			
			<section>
						<section>
							<header>
								<font size="6" color="#000000"><b>참여 모임</b></font>
								<hr>
							</header>

						</section>



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
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty joinList }">
										<tr>
											<th colspan="4 " class="text-center">모임이 존재하지 않습니다.</th>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="joinMeeting" items="${joinList }">
											<tr>
												<td class="text-center"><a
													href="meetingDetail.do?meetingId=${joinMeeting.meetingId }">${joinMeeting.meetingName }</a></td>
												<td class="text-center"><fmt:formatDate value="${joinMeeting.meetingDate}" pattern="yyyy-MM-dd" /></td>
												<td class="text-center">${joinMeeting.meetingTime }시</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>


			</section>

		</div>
		</div>
		</div>
</div>
		
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