<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<style type="text/css">
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
							<form action="modifyMeeting.do" method="POST"
								>
								<fieldset>
									<legend class="screen_out">모임 수정하기 폼</legend>
									<div class="form_details">


										<span class="cont_notice"><i class="fa fa-check"></i>필수항목</span>
										<input type="hidden" name="meetingId" value="${meetingDetail.meetingId }">
										<section>
											<label for="inpName" class="lab_comm"><strong
												class="tit_form"><i class="fa fa-check"></i>모임명</strong></label> <input
												type="text" id="inpName" name="meetingName" class="inp_comm" value ="${meetingDetail.meetingName }">
										</section>
										
										<div class="row" style="float:center; text-align: center; display:inline-block;">
												
												<fmt:formatDate value="${meetingDetail.meetingDate}" pattern='yyyy-MM-dd' var="date"/>
											
												<label for="inpName" class="lab_comm" style="padding:0"><strong
													class="tit_form"><i class="fa fa-check"></i>모임일자
												<input type="text" id="datepicker" name="meetingDate" value="${date }"/></strong></label>

												

												

										</div>

										

										

										<input type="submit"
											class="btn_comm btn_submit send_listing_place" value="수정"></input>
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