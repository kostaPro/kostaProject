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
<title>WithDog_RegistMeeting</title>
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
<script type="text/javascript" src="resources/js/meetingImage.js"></script>


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
	border: 1px solid #43C0CE;
	background-color: #43C0CE;
	font-size: 13px;
	color: #fff;
	line-height: 25px;
}

a.btn-popupClose:hover {
	border: 1px solid #128FA6;
	background-color: #128FA6;
	color: #fff;
}

a.btn-popupSearch {
	display: inline-block;
	height: 25px;
	padding: 0 14px 0;
	border: 1px solid #43C0CE;
	background-color: #43C0CE;
	font-size: 13px;
	color: #fff;
	line-height: 25px;
}

a.btn-popupSearch:hover {
	border: 1px solid #128FA6;
	background-color: #128FA6;
	color: #fff;
}

.imgs_wrap {
	width: 1100px;
	display: inline-block;
}

.imgs_wrap img {
	margin: 20px;
	max-width: 300px;
	float: left;
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
							<form action="registMeeting.do" method="POST"
								enctype="multipart/form-data">
								<fieldset>
									<legend class="screen_out">모임 등록하기 폼</legend>
									<div class="form_details">
										<input type="hidden" id="spotId" name="spotId"> <span
											class="cont_notice"><i class="fa fa-check"></i>필수항목</span>

										<section>
											<label for="inpName" class="lab_comm"><strong
												class="tit_form"><i class="fa fa-check"></i>모임명</strong></label> <input
												type="text" id="inpName" name="meetingName" class="inp_comm">
										</section>

										<div class="row"
											style="float: center; text-align: center; display: inline-block;">
											<label for="inpName" class="lab_comm" style="padding: 0"><strong
												class="tit_form"><i class="fa fa-check"></i>모임일자 <input
													type="text" id="datepicker" name="meetingDate"></strong></label> <label
												for="inpName" class="lab_comm" style="padding-left: 20px"><strong
												class="tit_form"><i class="fa fa-check"></i>모임시간 <select
													form="time" name="meetingTime">
														<option value="">시간</option>
														<option value=0>0시</option>
														<option value=1>1시</option>
														<option value=2>2시</option>
														<option value=3>3시</option>
														<option value=4>4시</option>
														<option value=5>5시</option>
														<option value=6>6시</option>
														<option value=7>7시</option>
														<option value=8>8시</option>
														<option value=9>9시</option>
														<option value=10>10시</option>
														<option value=11>11시</option>
														<option value=12>12시</option>
														<option value=13>13시</option>
														<option value=14>14시</option>
														<option value=15>15시</option>
														<option value=16>16시</option>
														<option value=17>17시</option>
														<option value=18>18시</option>
														<option value=19>19시</option>
														<option value=20>20시</option>
														<option value=21>21시</option>
														<option value=22>22시</option>
														<option value=23>23시</option>
												</select></strong></label> <label for="inpName" class="lab_comm"
												style="padding-left: 20px"><strong class="tit_form">최소인원<select
													form="time" name="minPerson">
														<option value="">인원</option>
														<option value=1>1명</option>
														<option value=2>2명</option>
														<option value=3>3명</option>
														<option value=4>4명</option>
														<option value=5>5명</option>
														<option value=6>6명</option>
														<option value=7>7명</option>
														<option value=8>8명</option>
														<option value=9>9명</option>
														<option value=10>10명</option>
														<option value=15>15명</option>
														<option value=20>20명</option>
														<option value=30>30명</option>
												</select></strong></label>

										</div>

										<section>
											<strong class="tit_form"><i class="fa fa-check"></i>모임
												관련 사진을 첨부해주세요.<i class="txt_check"> </i></strong> <label
												class="btn btn-info upload-button">이미지 첨부 <input
												style="display: none" type="file" name="file"
												id="input_imgs" multiple="multiple" />
											</label>
											<div class="imgs_wrap"></div>

										</section>

										<section style="display: inline-block; width: 650px">

											<strong class="tit_form"><i class="fa fa-check"></i>모임의
												주소를 입력해주세요.</strong> <input type="text" id="resultLocation"
												class="inp_comm" name="Spot"> <a href="#searchSpot"
												id="searchSpot_btn"
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
															class="btn-popupSearch" onclick="searchBtn_click()">검색하기</a>

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
															<a href="#addSpot" id="addSpotPop" class="btn-popupSearch" onclick="addSpotPop_click()">장소 추가</a> <a
																href="#" class="btn-popupClose">Close</a>
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
										</label>
										<textarea class="inp_comm" name="meetingPurpose"
											placeholder=""></textarea>


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

	<!-- addPopup -->
	<div class="add-layer">
		<div class="layerBg"></div>
		<div id="addSpot" class="pop-layer">
			<div class="pop-container">
				<div class="pop-conts">
					<!--content //-->

					<form action="" method="POST">
						<fieldset>
							<div class="form_details">

								<label for="inpName" class="lab_comm"><strong
									class="tit_form"><i class="fa fa-check"></i>장소명</strong></label> <input
									type="text" id="inpName" name="spotName" class="inp_comm">

								<section style="display: inline-block; width: 650px">
									<strong class="tit_form"><i class="fa fa-check"></i>장소
										분류를 선택해주세요.</strong>
									<ul class="list_type2">
										<li><input type="checkbox" id="etc" name="etc"
											disabled="disabled"> <label for="etc"
											class="link_cont"></label></li>

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
											disabled="disabled"> <label for="etc"
											class="link_cont"></label></li>
									</ul>

									<ul class="list_type2">
										<li><input type="checkbox" id="etc" name="event_type"
											disabled="disabled"> <label for="etc"
											class="link_cont"></label></li>

										<li><input type="radio" id="inpExhibit" name="spotType"
											value="공원"> <label for="inpExhibit" class="link_cont">
												<span class="ico_comm ico_exhibit"></span> <span
												class="txt_name">공원</span>
										</label></li>

										<li><input type="radio" id="inpUnique" name="spotType"
											value="숙박시설"> <label for="inpUnique"
											class="link_cont"> <span class="ico_comm ico_unique"></span>
												<span class="txt_name">숙박 시설</span></label></li>

										<li><input type="radio" id="inpExtra" name="spotType"
											value="기타"> <label for="inpExtra" class="link_cont"><span
												class="ico_comm ico_unique"></span> <span class="txt_name">기타</span></label></li>

										<li><input type="checkbox" id="etc" name="event_type"
											disabled="disabled"> <label for="etc"
											class="link_cont"></label></li>
									</ul>

								</section>


								<strong class="tit_form"><i class="fa fa-check"></i>공간의
									주소를 입력해주세요.</strong>

								<section>

									<input type="text" class="inp_comm" name="spotLocation"
										id="spotLocation"> <input type="button"
										onclick="searchingAddress()" value="검색하기"
										class="btn btn-primary btn-block form-control btn_comm">
								</section>

								<section>
									<div class="7u">
										<iframe name="mapFrame" id="mapFrame"
											style="width: 650px; height: 500px"
											src="http://wedog.dothome.co.kr/RegistSpotMark.html"></iframe>
									</div>
								</section>
								<input type="submit" class="btn_comm btn_submit registSpot"
									value="장소 등록"></input>
							</div>
						</fieldset>
					</form>
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