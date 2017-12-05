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
<title>WithDog_blackList</title>
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
</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->


	<!-- Main -->


	<div id="main">
		<div class="container">
			<div class="row half">
				<div class="5u">
					<section>
						<header>
							<h2>BlackList(관리자)</h2>
							<hr>
						</header>

					</section>
				</div>
			</div>

			<div class="row">
			<form action="">
				<div class="15u">

					<div>
						<table class="table table-striped table-bordered table-hover">
							<colgroup>
								<col width="300" />
								<col width="300" />
								<col width="200" />
							</colgroup>
							<thead>
								<tr>
									<th class="text-center">피신고자 ID</th>
									<th class="text-center">신고 횟수</th>
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
													href="reportDetail.do?reportTargetId=${blackList.reportTargetId  }">${blackList.reportTargetId }</a></td>
												<td class="text-center">${blackList.status }</td>
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


					</div>
				</div>
				</form>

			</div>
		</div>

	</div>

	<!-- /Main -->


	<!-- Copyright -->
	<div id="copyright">
		<div class="container">
			Design: <a href="">WITH DOG</a> Images: <a href="">WITH DOG</a> (<a
				href="">CC0</a>)
		</div>
	</div>
</body>
</html>
