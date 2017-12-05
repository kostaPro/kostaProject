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
<title>WithDog_adminReport</title>
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
							<h2>Report List(관리자)</h2>

						</header>

					</section>
				</div>
			</div>
			<form action="searchReportByType.do">
				<div class="row">
					<div class="15u">

						<select class="form-control" name="reportType" id="reportType">
							<option value="all">신고구분을 선택해주세요.</option>

							<option value="meeting">모임</option>
							<option value="spot">장소</option>
							<option value="review">평가글</option>
							<option value="comment">댓글</option>

						</select>
					</div>
					<div class="2u">
						<input type="submit" value="search"
							class="btn btn-primary btn-block form-control" id="search_btn"
							style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">
					</div>

				</div>
			</form>
			<div>
				<table class="table table-striped table-bordered table-hover">
					<colgroup>
						<col width="200" />
						<col width="200" />
						<col width="1000" />
						<col width="100" />
						<col width="100" />
					</colgroup>
					<thead>
						<tr>
							<th class="text-center">신고 구분</th>
							<th class="text-center">신고 대상</th>
							<th class="text-center">신고 사유</th>
							<th class="text-center">처리 상태</th>
							<th class="text-center"></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty reportList }">
								<tr>
									<th colspan="5 " class="text-center">신고가 존재하지 않습니다.</th>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="reportList" items="${reportList }">
									<tr>
										<td class="text-center"><a
											href="reportDetail.do?reportId=${reportList.reportTargetId }">${reportList.reportTargetId }</a></td>
										<td class="text-center">${reportList.reportTargetId }</td>
										<td class="text-center">${reportList.reportContent }</td>
										<td class="text-center"><select form="reportType"
											name="reportType">
												<option value="all">선택</option>

												<option value="1">경고</option>
												<option value="0">미경고</option>

										</select></td>
										<td><input type="submit" value="수정"
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

