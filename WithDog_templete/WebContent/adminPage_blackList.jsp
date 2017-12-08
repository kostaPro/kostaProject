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
<title>WithDog_Admin_BlackList</title>
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
.pp input, .pp select {
	float: left;
	margin: 0 10px;
	width: 33%;
}

.pp {
	content: "";
	display: block;
	clear: both;
}

.pp input:last-of-type {
	width: 100px;
	color: #fff;
	background: #43becc;
	border: 1px solid #43becc;
}

.text-center {
	width: 100px;
}

.text-ss {
	width: 10%;
	text-align: center;
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
				<%@include file="myPage_admin.jsp"%>
				<div id="content" class="9u skel-cell-important">
					<section>
						<section>
							<header>
								<font size="6" color="#000000"><b>Black List</b></font>
								<hr>
							</header>

						</section>


						<form action="removeUser.do">
							<table class="table table-striped table-bordered table-hover">

								<colgroup>
									<col width="400" />
									<col width="400" />
								</colgroup>
								<thead>
									<tr>

										<th class="text-center">피신고자 ID</th>
										<th class="text-center">경고 횟수</th>
										<th class="text-center"></th>

									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty blackList }">
											<tr>
												<th colspan="5 " class="text-center">신고가 존재하지 않습니다.</th>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="blackList" items="${blackList }">
												<tr>
													<td class="text-center"><a
														href="adminPage_suspectDetail.do?suspectId=${blackList.suspectId}">${blackList.suspectId}</a></td>
													<td class="text-center">${blackList.count}</td>
													<td><input type="submit" value="탈퇴"
														class="btn btn-primary btn-block form-control"
														id="search_btn"
														style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;"></td>
												</tr>

											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
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