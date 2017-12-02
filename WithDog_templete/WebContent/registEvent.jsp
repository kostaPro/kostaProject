<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
<title>WithDog_RegistEvent</title>
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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!--데이트피커-->
<script type="text/javascript" src="resources/js/eventDatepicker.js"></script>

<!--업로드한 이미지 미리보기-->
<script type="text/javascript" src="resources/js/spotImage.js"></script>

<!--팝업띄우기-->
<script type="text/javascript" src="resources/js/searchingSpot.js"></script>

<!--팝업용 css-->
<style type="text/css">

.pop-layer .pop-container {
	padding: 20px 25px;
}

.pop-layer p.ctxt {
	color: #666;
	line-height: 25px;
}

.pop-layer .btn-r {
	width: 100%;
	margin: 10px 0 20px;
	padding-top: 10px;
	border-top: 1px solid #DDD;
	text-align: right;
}

.pop-layer {
	display: none;
	position: absolute;
	top: 50%;
	left: 50%;
	width: 500px;
	height: auto;
	background-color: #fff;
	border: 5px solid #3571B5;
	z-index: 10;
}

.dim-layer {
	display: none;
	position: fixed;
	_position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 100;
}

.dim-layer .dimBg {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
}

.dim-layer .pop-layer {
	display: block;
}

a.btn-popupClose {
	display: inline-block;
	height: 25px;
	padding: 0 14px 0;
	border: 1px solid #304a8a;
	background-color: #3f5a9d;
	font-size: 13px;
	color: #fff;
	line-height: 25px;
}

a.btn-popupClose:hover {
	border: 1px solid #091940;
	background-color: #1f326a;
	color: #fff;
}

a.btn-popupSearch {
	display: inline-block;
	height: 32px;
	padding: 0 14px 0;
	border: 1px solid #304a8a;
	background-color: #3f5a9d;
	font-size: 13px;
	align-content: center;
	color: #fff;
}

a.btn-popupSearch:hover {
	border: 1px solid #091940;
	background-color: #1f326a;
	color: #fff;
}

</style>

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
			<h2 class="screen_out">Listing Place 서비스 본문</h2>
			<!-- 2015-08-03 마크업 추가 -->
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<!-- step1 시작-->

						<div class="wrap_listing">
							<form action="registEvent.do" method="POST"
								enctype="multipart/form-data">
								<fieldset>
									<legend class="screen_out">이벤트 등록하기 폼</legend>
									<div class="form_details">


										<span class="cont_notice"><i class="fa fa-check"></i>필수항목</span>

										<label for="inpName" class="lab_comm"><strong
											class="tit_form"><i class="fa fa-check"></i>이벤트명</strong></label> <input
											type="text" id="inpName" name="eventName" class="inp_comm">

										<section>
											<strong class="tit_form"><i class="fa fa-check"></i>이벤트의
												대표 사진을 첨부해주세요.<i class="txt_check"> </i></strong>
											<div class="file_area">
												<div class="file_comm">
													<span class="thumbnail_name"></span> <span class="btn_file"><label>파일첨부</label>
														<input type="file" id="input_thumbnail" name="eventImg"
														class="inp_file file_attach"> </span> <br> <br>
													<img src="#" id="spot_thumb"
														style="width: 600px; display: absolute; float: center">

												</div>
											</div>
										</section>

										<section style="display: inline-block; width: 650px">

											<strong class="tit_form"><i class="fa fa-check"></i>이벤트
												장소를 입력해주세요.</strong> <input type="text" class="inp_comm" id= "eventLocation" name="eventLocation"> 
												<a href="#searchSpot" id="searchSpot_btn"
												class="btn btn-primary btn-block form-control btn_comm" onclick="searchSpotBtn_click()">검색하기</a>

										</section>
										
										
										<!-- Popup -->
										<div class="dim-layer">
											<div class="dimBg"></div>
											<div id="searchSpot" class="pop-layer">
												<div class="pop-container">
													<div class="pop-conts">
														<!--content //-->
														
															<input type="text" placeholder="주소를 입력해 주세요">
															
															<a href="#" class="btn-popupSearch">검색하기</a>
														
														<table class="table table-striped table-bordered table-hover">
						<colgroup>
							<col width="400" />
							<col width="800" />
							<col width="300" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">장소 명</th>
								<th class="text-center">장소 위치</th>
								<th class="text-center">장소 분류</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty spotList }">
									<tr>
										<th colspan="3 " class="text-center">장소가 존재하지 않습니다.</th>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="spot" items="${spotList }">
										<tr>
											<td class="text-center"><a
												href="spotDetail.do?spotId=${spot.spotId }">${spot.spotName }</a></td>
											<td class="text-center">${spot.spotLocation }</td>
											<td class="text-center">${spot.spotType }</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>

														<div class="btn-r">
															<a href="#" class="btn-popupClose">Close</a>
														</div>
														<!--// content-->
													</div>
												</div>
											</div>
										</div>
										<!-- /Popup -->

										<section>
											<div class="row">
												<label for="inpName" class="lab_comm"><strong
													class="tit_form"> <i class="fa fa-check"></i>시작일
												</strong></label> <input type="text" id="eventOpenDate" name="openDate">

												<label for="inpName" class="lab_comm"><strong
													class="tit_form"> <i class="fa fa-check"></i>종료일
												</strong></label> <input type="text" id="eventCloseDate" name="closeDate">
											</div>
										</section>
										<section>
											<label for="inpComp" class="lab_comm"> <strong
												class="tit_form"><i class="fa fa-check"></i>소개글<i
													class="txt_check"></i></strong>
											</label>
											<textarea class="inp_comm" name="eventInfo" placeholder=""></textarea>
										</section>

										<input type="submit"
											class="btn_comm btn_submit send_listing_place" value="등록신청"></input>
									</div>
								</fieldset>
							</form>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- /Main -->

	<!-- Footer -->

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