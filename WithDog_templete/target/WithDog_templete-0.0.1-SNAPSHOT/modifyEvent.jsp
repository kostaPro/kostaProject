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

<!--데이트피커-->
<script type="text/javascript" src="resources/js/eventDatepicker.js"></script>

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
							<form action="modifyEvent.do" method="POST" enctype="multipart/form-data">
							<input type="hidden" name="eventId" value="${event.eventId }">
								<fieldset>
									<legend class="screen_out">이벤트 수정하기 폼</legend>
									<div class="form_details">

										<span class="cont_notice"><i class="fa fa-check"></i>필수항목</span>

										<p>
											<i class="fa fa-check"></i> 시작일: <input type="text"
												id="eventOpenDate" name="openDate" value="${event.openDate }">
										</p>

										<p>
											<i class="fa fa-check"></i> 종료일: <input type="text"
												id="eventCloseDate" name="closeDate"
												value="${event.closeDate }">
										</p>

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

										</section>


										<strong class="tit_form"><i class="fa fa-check"></i>이벤트의
											주소를 입력해주세요.</strong>

										<section>

											<input type="text" class="inp_comm" name="eventLocation" value="${event.eventName }">
											<a href="#"
												class="btn btn-primary btn-block form-control btn_comm"><strong
												style="color: white">검색하기</strong></a>
										</section>

										<label for="inpComp" class="lab_comm"> <strong
											class="tit_form"><i class="fa fa-check"></i>소개글<i
												class="txt_check"></i></strong>
										</label>
										<input type="text" class="inp_comm" name="eventInfo" placeholder="" value="${event.eventInfo }"></input>

										<input type="submit"
											class="btn_comm btn_submit send_listing_place" value="수정신청" ></input>

										<button type="submit"
											class="btn_comm btn_submit send_listing_place"
											onclick="eventDetail.do?eventId=${event.eventId }">수정취소</button>
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