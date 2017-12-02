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
<meta name="description" content="" />
<meta name="keywords" content="" />

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">




<link rel='stylesheet' id='jquery-ui-css'
	href='http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='acf-global-css'
	href='http://www.sweetspot.co.kr/wp-content/plugins/advanced-custom-fields-pro/assets/css/acf-global.css?ver=5.2.6'
	type='text/css' media='all' />
<link rel='stylesheet' id='select2-css'
	href='http://www.sweetspot.co.kr/wp-content/plugins/advanced-custom-fields-pro/assets/inc/select2/select2.css?ver=5.2.6'
	type='text/css' media='all' />
<link rel='stylesheet' id='acf-input-css'
	href='http://www.sweetspot.co.kr/wp-content/plugins/advanced-custom-fields-pro/assets/css/acf-input.css?ver=5.2.6'
	type='text/css' media='all' />
<link rel='stylesheet' id='acf-pro-input-css'
	href='http://www.sweetspot.co.kr/wp-content/plugins/advanced-custom-fields-pro/pro/assets/css/acf-pro-input.css?ver=5.2.6'
	type='text/css' media='all' />
<link rel='stylesheet' id='contact-form-7-css'
	href='http://www.sweetspot.co.kr/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=4.2.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='plugin-member-wa-css'
	href='http://www.sweetspot.co.kr/wp-content/plugins/member-wa/common/css/member-wa-style.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='plugin-member-wa-templates-css'
	href='http://www.sweetspot.co.kr/wp-content/plugins/member-wa/common/css/member-wa-template.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='thcu-styles-css'
	href='http://www.sweetspot.co.kr/wp-content/plugins/theme-customization/css/renewal.css?ver=4.8.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='bootstrap-css'
	href='//netdna.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css'
	type='text/css' media='all' />
<link rel='stylesheet' id='font-awesome-css'
	href='//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'
	type='text/css' media='all' />
<link rel='stylesheet' id='google-font-css'
	href='//fonts.googleapis.com/css?family=Lato:100,100italic,300,300italic,regular,italic,700,700italic,900,900italic'
	type='text/css' media='all' />
<link rel='stylesheet' id='chosen-select-css'
	href='http://www.sweetspot.co.kr/wp-content/themes/realty/assets/chosen/chosen.min.css'
	type='text/css' media='all' />
<link rel='stylesheet' id='style-css'
	href='http://www.sweetspot.co.kr/wp-content/themes/realty-child/style.css'
	type='text/css' media='all' />
<link rel='stylesheet' id='print-css'
	href='http://www.sweetspot.co.kr/wp-content/themes/realty/print.css'
	type='text/css' media='print' />
<link rel='stylesheet' id='buttons-css'
	href='http://www.sweetspot.co.kr/wp-includes/css/buttons.min.css?ver=4.8.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='dashicons-css'
	href='http://www.sweetspot.co.kr/wp-includes/css/dashicons.min.css?ver=4.8.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='mediaelement-css'
	href='http://www.sweetspot.co.kr/wp-includes/js/mediaelement/mediaelementplayer.min.css?ver=2.22.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='wp-mediaelement-css'
	href='http://www.sweetspot.co.kr/wp-includes/js/mediaelement/wp-mediaelement.min.css?ver=4.8.1'
	type='text/css' media='all' />

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>



<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->

<script src="resources/js/skel.min.js"></script>
<script src="resources/js/skel-panels.min.js"></script>
<script src="resources/js/init.js"></script>
<link rel="stylesheet" href="resources/css/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

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
			<form class="property-search-form" action="meetingList.do"
				method="post">


				<div class="row">
					<p>
						<input type="text" id="datepicker" value="날짜를 선택해주세요.">
					</p>
					<div class="3u">
						<select form="location" name="favoriteLocation">
							<option value="all">지역을 선택해주세요.</option>


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
						<input type="text" placeholder="장소명을 입력해주세요" name="spotName" class="form-control" />
					</div>




					<div class="3u">
						<input type="submit" value="search"
							class="btn btn-primary btn-block form-control" id="search_btn"
							style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;"
							onclick="">
					</div>

				</div>

				<!-- Default Order: Newest Properties First -->
				<input type="hidden" name="order-by" value="date-new" /> <input
					type="hidden" name="pageid" value="841" />
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
								<hr>
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
									<th class="text-center">모임 명</th>
									<th class="text-center">모임 일자</th>
									<th class="text-center">종료일</th>
									<th class="text-center">이벤트 장소</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty meetingList }">
										<tr>
											<th colspan="4 " class="text-center">이벤트가 존재하지 않습니다.</th>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="meetingList" items="${meetingList }">
											<tr>
												<td class="text-center"><a
													href="meetingDetail.do?meetingId=${meetingList.meetingId }">${meetingList.meetingName }</a></td>
												<td class="text-center"><fmt:formatDate value="${meetingList.meetingDate}" pattern="yyyy-MM-dd" /></td>
												<td class="text-center">${meetingList.meetingPurpose }</td>
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