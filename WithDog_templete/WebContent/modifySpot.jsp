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
<title>WithDog_RegistSpot</title>
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

<!--업로드한 이미지 미리보기-->
<script type="text/javascript" src="resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/spotImage.js"></script>

<!--주소 검색-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/searchingAddress.js"></script>

<!--showMap-->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=RQUNwC26q24ETH0hzeGg&submodules=geocoder"></script>

<!--미리보기 용 css-->
<style type="text/css">
.spot_imgs {
	width: 1100px;
	display: inline-block;
}

.spot_imgs img {
	margin: 20px;
	max-width: 300px;
	float: left;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	var typeVal = $("#setUpType").val();
	$(input:radio[name=spotType]:input[value=typeVal]).attr("checked",true);
});
</script>
</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->


	<!-- Main -->
	<div id="main">

		<div class="container">
			<h2 class="screen_out">장소 수정 양식</h2>
			<!-- 2015-08-03 마크업 추가 -->
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<!-- step1 시작-->

						<div class="wrap_listing">
							<form action="modifySpot.do" method="POST"
								enctype="multipart/form-data">
								<fieldset>
									<legend class="screen_out">장소 수정하기 폼</legend>
									<div class="form_details">
										<span class="cont_notice"><i class="fa fa-check"></i>\필수항목</span>

										<label for="inpName" class="lab_comm"><strong
											class="tit_form"><i class="fa fa-check"></i>장소명</strong></label> <input
											type="text" readonly="readonly" id="inpName" name="spotName"
											class="inp_comm" value="${spotDetail.spotName }">

										<section>
											<strong class="tit_form">장소의 대표 사진을 첨부해주세요.<i
												class="txt_check"> (선택)</i></strong>
											<div class="file_area">
												<div class="file_comm">
													<span class="thumbnail_name"></span> <span class="btn_file"><label>파일첨부</label>
														<input type="file" id="input_thumbnail"
														name="spotThumbnail" class="inp_file file_attach">
													</span> <br> <br> <img src="#" id="spot_thumb"
														style="width: 600px; display: absolute; float: center">

												</div>
											</div>
										</section>

										<input type="hidden" id="setUpType"
											value="${spotDetail.spotType }">
										<section style="display: inline-block; width: 650px">
											<strong class="tit_form"><i class="fa fa-check"></i>장소
												분류를 선택해주세요.</strong>
											<ul class="list_type2">
												<li><input type="checkbox" id="etc" name="etc"
													disabled="disabled"> <label for="etc"
													class="link_cont"></label></li>

												<li><input type="radio" id="inpStore" name="spotType"
													value="동물병원"> <label for="inpStore"
													class="link_cont"><span class="ico_comm ico_shop"></span><span
														class="txt_name">동물 병원</span></label></li>
												<li><input type="radio" id="inpEvent" name="spotType"
													value="애견샵"> <label for="inpEvent"
													class="link_cont"><span class="ico_comm ico_event"></span><span
														class="txt_name">애견 샵</span></label></li>
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
													value="공원"> <label for="inpExhibit"
													class="link_cont"> <span
														class="ico_comm ico_exhibit"></span> <span
														class="txt_name">공원</span></label></li>

												<li><input type="radio" id="inpUnique" name="spotType"
													value="숙박시설"> <label for="inpUnique"
													class="link_cont"> <span
														class="ico_comm ico_unique"></span> <span class="txt_name">숙박
															시설</span></label></li>

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
												id="spotLocation" value="${spotDetail.spotLocation }"> <input type="button"
												onclick="searchingAddress()" value="검색하기"
												class="btn btn-primary btn-block form-control btn_comm">
										</section>

										<section>
											<div id="map" style="width: 100%; height: 300px;"></div>
										</section>

										<label for="inpComp" class="lab_comm"> <strong
											class="tit_form">소개글<i class="txt_check"> (선택)</i></strong>
										</label>
										<textarea class="inp_comm" name="spotInfo" placeholder="" value="${spotDetail.spotInfo }"></textarea>

										<strong class="tit_form">장소의 사진(이미지 파일)을 첨부해주세요.<i
											class="txt_check"> (선택)</i></strong>
										<div class="file_area">
											<div class="file_comm">
												<span class="file_name"></span> <span class="btn_file">
													<label>파일첨부</label> <input type="file" id="input_imgs"
													name="spotImage" class="inp_file file_attach"
													multiple="multiple">
												</span>
											</div>
										</div>
										<span class="file_notice">최대 3개까지 첨부 가능</span>
										<section>
											<div class="spot_imgs"></div>
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
			Design: <a href="">WITH DOG</a> Images: <a href="">WITH DOG</a> (<a
				href="">CC0</a>)
		</div>
	</div>
</body>
</html>