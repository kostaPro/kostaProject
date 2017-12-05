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

												<label for="inpName" class="lab_comm"  style="padding-left: 20px"><strong
													class="tit_form"><i class="fa fa-check"></i>모임시간
													<select form="time" name="meetingTime">
													<option value=${meetingDetail.meetingTime }>${meetingDetail.meetingTime }시</option>
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
												</select></strong></label>

												<label for="inpName" class="lab_comm"  style="padding-left: 20px"><strong
													class="tit_form">최소인원<select form="time"
													name="minPerson">
													<option value=${meetingDetail.minPerson }>${meetingDetail.minPerson }명</option>
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
												style="display: none" />
											</label>
				<div class="row">
					<c:forEach var="mImage" items="${meetingDetail.meetingImageList}">
						<div class="4u">
							<section>
								<img class="imgs" src="/images/${mImage}" />
							</section>
						</div>
					</c:forEach>
				</div>
				</section>


										<section style="display: inline-block; width: 650px">

											<strong class="tit_form"><i class="fa fa-check"></i>모임의
												주소를 입력해주세요.</strong> <input type="text" class="inp_comm" >
											<a href="#"
												class="btn btn-primary btn-block form-control btn_comm"><strong
												style="color: white">검색하기</strong></a>

										</section>

										<section>
										<label for="inpComp" class="lab_comm"> <strong
											class="tit_form"><i class="fa fa-check"></i>소개글<i
												class="txt_check"></i></strong>
										</label>
										<textarea class="inp_comm" name="meetingPurpose"
											>${meetingDetail.meetingPurpose }</textarea>
										</section>

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