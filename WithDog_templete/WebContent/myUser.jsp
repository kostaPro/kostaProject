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


<style type="text/css">


table{
width:60%;
height:100px;
margin:auto;
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
			<div class="row">
		<%@include file="myPage_user.jsp"%>
			<div id="content" class="9u skel-cell-important">
					<section>
						<section>
							<header>
								<font size="6" color="#000000"><b>회원 정보</b></font>
								<hr>
							</header>

						</section>



						<form action="modifyMeeting.do" method="POST"
								>
								<fieldset>
									<legend class="screen_out">모임 수정하기 폼</legend>
									<div class="form_details">


										<span class="cont_notice"><i class="fa fa-check"></i>필수항목</span>
										<input type="hidden" name="meetingId" value="${meetingDetail.meetingId }">
										
										<table>
										<tr>
											<th><label for="inpName" class="lab_comm"><strong
												class="tit_form"><i class="fa fa-check"></i>비밀번호</strong></label></th> <th><input
												type="password" id="inpName" name="meetingName" class="inp_comm" value ="${meetingDetail.meetingName }" style="width:200px;" ></th>
										</tr>
										
										<tr>
											<th><label for="inpName" class="lab_comm"><strong
												class="tit_form"><i class="fa fa-check"></i>비밀번호 확인</strong></label></th> <th><input
												type="password" id="inpName" name="meetingName" class="inp_comm" value ="${meetingDetail.meetingName }" style="width:200px;" ></th>
										</tr>
										
										<tr>
											<th><label for="inpName" class="lab_comm"><strong
												class="tit_form"><i class="fa fa-check"></i>연락처</strong></label></th> <th><input
												type="text" id="inpName" name="meetingName" class="inp_comm" value ="${meetingDetail.meetingName }" style="width:200px;"></th>
										</tr>
										
										
										<tr>
										<th><label for="inpName" class="lab_comm"><strong
												class="tit_form"><i class="fa fa-check"></i>선호 지역</strong></label></th>
												
										<th><select name="favoriteLocation" style="width:200px;">
                    						  <option value=""></option>
                   							  <option value="서울">서울</option>
                   							  <option value="경기">경기</option>
                   							  <option value="인천">인천</option>
                  							  <option value="강원">강원</option>
                  							  <option value="부산">부산</option>
                  							  <option value="경남">경남</option>
                  							  <option value="전남">전남</option>
                  							  <option value="전북">전북</option>
                   							  <option value="경북">경북</option>
                     						  <option value="충남">충남</option>
                     						  <option value="충북">충북</option>
             						          <option value="제주특별자치도">제주</option>
                  						</select></th>
										</tr>
										<tr>
										<th><label for="inpComp" class="lab_comm"> <strong
											class="tit_form"><i class="fa fa-check"></i>애견 정보<i
												class="txt_check"></i></strong>
										</label></th>
										<th><input type="text" class="inp_comm" name="meetingPurpose"
											value="${meetingDetail.meetingPurpose }" style="width:200px;"></th>
										</tr>
										</table>

										<input type="submit"
											class="" value="수정"></input>
									</div>
								</fieldset>
							</form>

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