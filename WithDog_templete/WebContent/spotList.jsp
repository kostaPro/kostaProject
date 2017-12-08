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
<title>WithDog_spotList</title>
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

<!--showMap-->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=CWzOw4q7QmEGUpLcMF2H&submodules=geocoder"></script>
<script type="text/javascript" src="resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/markMultipleSpot.js"></script>

<!--js로 spot객체리스트 넘기기-->
<script type="text/javascript">
	var spots = new Array();

	<c:forEach var="spot" items="${spotList }">

	var spotObj = new Object();

	spotObj.spotLocation = "${spot.spotLocation}";
	spotObj.spotId = "${spot.spotId}";
	spotObj.spotName = "${spot.spotName}";

	spots.push(spotObj);
	</c:forEach>

	markMultipleSpot(JSON.stringify(spots));
</script>
</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->


	<!-- Main -->
	<div id="main">

		<div class="container">
			<form class="property-search-form" action="spotList.do" method="post">
				<div class="row">

					<div class="3u">
						<input type="text" placeholder="주소를 입력해주세요" name="spotLocation"
							id="spotLocation" class="form-control" />
					</div>


					<div class="3u">
						<select name="spotType" id="spotType" class="form-control">
							<option value="">분류를 선택해주세요.</option>
							<option value="동물병원">
				            동물병원					        </option>
							<option value="애견샵">
				            애견 샵				        </option>
							<option value="애견카페">
				            애견 카페					        </option>
							<option value="공원">
				            공원					        </option>
							<option value="이벤트">
				            이벤트					        </option>
							<option value="숙박시설">
				            숙박 시설					        </option>
							<option value="기타">
				            기타					        </option>

						</select>
					</div>

					<div class="3u">
						<input type="text" placeholder="장소명을 입력해주세요" name="spotName"
							class="form-control" />
					</div>

					<div class="3u">
						<input type="submit" value="search"
							class="btn btn-primary btn-block form-control" id="search_btn"
							style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">
					</div>

				</div>

			</form>
			<div id="map" style="width: 100%; height: 400px;"></div>
		</div>
	</div>
	<!-- /Main -->

	<!-- Footer -->
	<div id="footer">
		<div class="container">

			<div class="row half">
				<div class="3u">
					<section>
						<header>
							<h2>Spot List</h2>
							<hr>
						</header>

					</section>
				</div>
			</div>

			<div class="row">
				<div class="15u">


					<table class="table table-striped table-bordered table-hover">
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
						<tbody>
							<c:choose>
								<c:when test="${empty spotList }">
									<tr>
										<th colspan="3 " class="text-center">장소가 존재하지 않습니다.</th>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="spot" items="${spotList }">
										<input type="hidden" id="spotList" name="spotList"
											value="${spotList }">
										<tr>
											<td class="text-center"><a
												href="spotDetail.do?spotId=${spot.spotId }">${spot.spotName }</a></td>
											<td class="text-center">${spot.spotLocation }</td>
											<td class="text-center">${spot.spotType }</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>


				</div>
			</div>
			<div class="3u">
				<a href="registSpot.do" class="btn_comm btn_submit form-control"
					style="text-align: center"><strong style="color: white">장소
						등록</strong></a>
			</div>

		</div>
	</div>
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
