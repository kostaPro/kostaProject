<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Elemental by TEMPLATED
    templated.co @templatedco
    Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>WithDog_ModifyEvent</title>
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

<!--데이트피커/미리보기를 위란 기본 파일-->
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

<!--주소 검색-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript"
	src="resources/js/searchingAddress_pop.js"></script>

<!--장소조회 팝업띄우기-->
<script type="text/javascript" src="resources/js/searchingSpot.js"></script>

<!--장소추가 팝업띄우기-->
<script type="text/javascript" src="resources/js/addSpot.js"></script>


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
	width: 800px;
	height: auto;
	background-color: #fff;
	border: 5px solid #43C0CE;
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

.add-layer {
	display: none;
	position: fixed;
	_position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 100;
}

.add-layer .addLayerBg {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
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

.add-layer .pop-layer {
	display: block;
}

.dim-layer .pop-layer {
	display: block;
}

a.btn-popup {
	display: inline-block;
	height: 25px;
	padding: 0 14px 0;
	border: 1px solid #43C0CE;
	background-color: #43C0CE;
	font-size: 13px;
	color: #fff;
	line-height: 25px;
}

a.btn-popup:hover {
	border: 1px solid #128FA6;
	background-color: #128FA6;
	color: #fff;
}
</style>

</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
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

							<form action="modifyEvent.do" method="POST"
								enctype="multipart/form-data">

								<input type="hidden" name="eventId" value="${event.eventId }">
								<fieldset>
									<legend class="screen_out">이벤트 수정하기 폼</legend>
									<div class="form_details">
										<input type="hidden" id="spotId" name="spotId"
											value="${event.eventSpot.spotId }"> <span
											class="cont_notice"><i class="fa fa-check"></i>필수항목</span><br>
										<br>

										<section>
											<div class="row">
												<p>
													<label for="inpName" class="lab_comm" style="float: center"><strong
														class="tit_form"> <i class="fa fa-check"></i>시작일
													</strong></label> <input type="text" id="openDate" name="openDate"
														value="${event.openDate }"
														style="text-align: center; float: center; width: 295px">

												</p>

												<p>
													<label for="inpName" class="lab_comm"
														style="float: center;"><strong class="tit_form">
															<i class="fa fa-check"></i>종료일
													</strong></label> <input type="text" id="closeDate" name="closeDate"
														value="${event.closeDate }"
														style="text-align: center; float: center; width: 295px">
												</p>
											</div>
										</section>
										<label for="inpName" class="lab_comm"><strong
											class="tit_form"><i class="fa fa-check"></i>이벤트명</strong></label> <input
											type="text" id="inpName" name="eventName" class="inp_comm"
											value="${event.eventName }" readOnly>

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
												장소를 입력해주세요.</strong> <input type="text" class="inp_comm"
												id="resultLocation" name="eventLocation"
												value="${event.eventSpot.spotLocation }"> <a
												href="#searchSpot" id="searchSpot_btn"
												class="btn btn-primary btn-block form-control btn_comm"
												onclick="searchPopBtn_click()">검색하기</a>

										</section>


										<!-- searchPopup -->
										<div class="dim-layer">
											<div class="dimBg"></div>
											<div id="searchSpot" class="pop-layer">
												<div class="pop-container">
													<div class="pop-conts">
														<!--content //-->

														<input id="locationBox" type="text"
															placeholder="주소를 입력해 주세요"> <a
															class="btn-popup btn-popupSearch"
															onclick="searchBtn_click()">검색하기</a>

														<table
															class="table table-striped table-bordered table-hover"
															id="spotTable" style="margin-top: 20px">
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

															<tbody id="spotData">

															</tbody>
														</table>


														<div class="btn-r">
															<a href="#addSpot" id="addSpotPop"
																class="btn-popup btn-popupSearch"
																onclick="addSpotPop_click()">장소 추가</a> <a href="#"
																class="btn-popup btn-popupClose">Close</a>
														</div>
														<!--// content-->
													</div>
												</div>
											</div>
										</div>
										<!-- /searchPopup -->

										<label for="inpComp" class="lab_comm"> <strong
											class="tit_form"><i class="fa fa-check"></i>소개글<i
												class="txt_check"></i></strong>
										</label> <input type="text" class="inp_comm" name="eventInfo"
											placeholder="" value="${event.eventInfo }"></input> <input
											type="submit" class="btn_comm btn_submit send_listing_place"
											value="수정신청"></input>

										<button type="button"
											class="btn_comm btn_submit send_listing_place"
											onclick="location.href='eventDetail.do?eventId=${event.eventId }'">수정취소</button>
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

	<!-- addPopup -->
	<div class="add-layer">
		<div class="addLayerBg"></div>
		<div id="addSpot" class="pop-layer">
			<div class="pop-container">
				<div class="pop-conts">
					<!--content //-->

					<div class="registSpot"
						style="display: table; margin-left: auto; margin-right: auto;">

						<section class="item" style="text-align: center">
							<label for="inpName" class="lab_comm"><strong
								class="tit_form"><i class="fa fa-check"></i>장소명</strong></label> <input
								type="text" id="inpName" name="spotName" class="inp_comm"
								style="width: 80%">
						</section>

						<section class="item" style="text-align: center">
							<strong class="tit_form"><i class="fa fa-check"></i>장소
								분류를 선택해주세요.</strong>
							<ul class="list_type2">

								<li><input type="checkbox" id="etc" name="etc"
									disabled="disabled"> <label for="etc" class="link_cont"></label></li>

								<li><input type="radio" id="inpStore" name="spotType"
									value="동물병원"> <label for="inpStore" class="link_cont"><span
										class="ico_comm ico_shop"></span><span class="txt_name">동물
											병원</span></label></li>

								<li><input type="radio" id="inpEvent" name="spotType"
									value="애견샵"> <label for="inpEvent" class="link_cont"><span
										class="ico_comm ico_event"></span><span class="txt_name">애견
											샵</span></label></li>

								<li><input type="radio" id="inpFnb" name="spotType"
									value="애견카페"> <label for="inpFnb" class="link_cont"><span
										class="ico_comm ico_fnb"></span><span class="txt_name">애견
											카페</span></label></li>

								<li><input type="checkbox" id="etc" name="etc"
									disabled="disabled"> <label for="etc" class="link_cont"></label></li>

							</ul>

							<ul class="list_type2">
								<li><input type="checkbox" id="etc" name="etc"
									disabled="disabled"> <label for="etc" class="link_cont"></label></li>

								<li><input type="radio" id="inpExhibit" name="spotType"
									value="공원"> <label for="inpExhibit" class="link_cont">
										<span class="ico_comm ico_exhibit"></span> <span
										class="txt_name">공원</span>
								</label></li>

								<li><input type="radio" id="inpUnique" name="spotType"
									value="숙박시설"> <label for="inpUnique" class="link_cont">
										<span class="ico_comm ico_unique"></span> <span
										class="txt_name">숙박 시설</span>
								</label></li>

								<li><input type="radio" id="inpExtra" name="spotType"
									value="기타"> <label for="inpExtra" class="link_cont"><span
										class="ico_comm ico_unique"></span> <span class="txt_name">기타</span></label></li>

								<li><input type="checkbox" id="etc" name="etc"
									disabled="disabled"> <label for="etc" class="link_cont"></label></li>
							</ul>

						</section>

						<section style="width: 500px; text-align: center">

							<strong class="tit_form"><i class="fa fa-check"></i>공간의
								주소를 입력해주세요.</strong> <input type="text" class="inp_comm"
								name="spotLocation" id="spotLocation" style="width: 100%">
							<input type="button" onclick="searchingAddress()" value="검색하기"
								class="btn btn-primary btn-block form-control btn_comm">
						</section>

						<div class="btn-r">
							<a href="#" id="addSpot"
								class="btn-popup btn-addSpot btn-popupClose" onclick="addSpot()">장소
								등록</a>
						</div>
					</div>
					<!--// content-->
				</div>
			</div>
		</div>
	</div>
	<!-- /addPopup -->

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