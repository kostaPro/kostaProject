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
<title>WithDog_mySpotList</title>
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
								<font size="3" color="#000000"><b>내 장소</b></font>
								
							</header>

						</section>



						<table class="table table-striped table-bordered table-hover">
							<colgroup>
								<col width="200" />
								<col width="200" />
								<col width="500" />
								<col width="100" />
								<col width="100" />
							</colgroup>
							<thead>
								<tr>
									<th class="text-center">장소 분류</th>
									<th class="text-center">장소명</th>
									<th class="text-center">장소 위치</th>
									<th class="text-ss">수정</th>
									
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty spotList }">
										<tr>
											<th colspan="4 " class="text-center">등록한 장소가 존재하지 않습니다.</th>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="spotList" items="${spotList}">
											<tr>
												<td class="text-center">${spotList.spotType }</td>
												<td class="text-center"><a
													href="spotDetail.do?spotId=${spotList.spotId }">${spotList.spotName }</a></td>
												<td class="text-center">${spotList.spotLocation }</td>
												<td><a href="modifySpot.do?spotId=${spotList.spotId }"><img src="resources/img/modify.png" style="width: 25px; height: auto; vertical-align:right;" alt=""></a></td>
												
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