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
<title>WithDog_eventDetail</title>
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

<!--목록접기를 위한 jQuery추가 -->
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>


<style type="text/css">
</style>
<style>
.joinDate a {
	cursor: pointer;
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
				<div class="3u" style="float: right; margin-right: 30px">
					<a href="eventList.do" class="btn_comm btn_submit form-control"
						style="text-align: center;"> <strong style="color: white">이벤트목록으로</strong></a>
				</div>
			</div>

			<div class="row">
				<section>

					<header>
						<h2 align="left">${eventDetail.eventName }</h2>
					</header>


					<div class="row">
						<section>
							<div class="row">
								<h3 align="left">
									시작일 |
									<fmt:formatDate value="${eventDetail.openDate}"
										pattern="yyyy-MM-dd" />
								</h3>
								<h3 align="left">
									종료일 |
									<fmt:formatDate value="${eventDetail.closeDate}"
										pattern="yyyy-MM-dd" />
								</h3>
							</div>

							<h3 align="left">장소 |</h3>

							<a href="#" class="image full"><img
								src="/images/${eventDetail.eventImage}" style="width: 370px"></a>
						</section>
					</div>

				</section>

				<section>
					<div class="7u">
						<iframe style="width: 760px; height: 500px"
							src="http://wedog.dothome.co.kr/detailSpotMark.html?city_do=${locationDo }&gu_gun=${locationGu }&dong=${locationDong }&bunji=${locationBunji}"></iframe>
					</div>
				</section>

			</div>

			<section>
				<div style="border: 2px solid; padding: 10px;">

					<h2>이벤트 소개</h2>
					<h3>${eventDetail.eventInfo}</h3>
				</div>
			</section>

			<section>
				<div
					style="border: 2px solid; padding: 10px; background-color: #43C0CE">

					<hr style="width: 30%; border: solid 2px white">
					<h1 style="font-size: 40px; margin-top: 10px; margin-bottom: 10px">참여자
						목록</h1>
					<hr style="width: 30%; border: solid 2px white">

					<c:forEach var="dateFlag" items="${eventPeriod }" varStatus="status">
						
						<div class="row">
							<div class="joinDate">
								<h3 style="font-size: 30px; margin-left: 10px;">
								<fmt:formatDate value="${dateFlag }" pattern="yyyy-MM-dd" var="joinDate" />
									[ <c:out value="${joinDate }"></c:out> ] 
									<Button name="spreadBtn" class="btn_comm" onclick="showList(${status.count})">▼</Button> 
								</h3>
							</div>

							<div class="1u" style="padding: 5px;">
								<div style="background-color: #FFF;">
									<a href="joinEvent.do?eventId=${eventDetail.eventId }&date=${joinDate }" ><strong><font color="#43C0CE">참여하기</font></strong></a>
								</div>
							</div>
						</div>

						<div id="dailyJoinList${status.count }" class="joinList" style="display: none">
							<c:forEach var="rowCount" begin="1" end="1" step="1">
								<div class="row" style="margin-top: 20px">

									<c:forEach var="colCount" begin="1" end="6" step="1">

										<div class="2u">
											<div
												style="width: 95%; background-color: #FFF; border-radius: 50px; -moz-border-radius: 50px; -khtml-border-radius: 50px; -webkit-border-radius: 50px;">
												<h2>${loginUser.userId }</h2>
												<img
													style="margin: 10px; width: 80%; border: 3px solid gold; border-radius: 120px; -moz-border-radius: 120px; -khtml-border-radius: 120px; -webkit-border-radius: 120px;"
													src="/images/${loginUser.petImage}">
												<h2>포메라니안/3Y/Female</h2>
												<h2>${loginUser.contact }</h2>
											</div>

										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
					</c:forEach>

				</div>
			</section>

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
							<h2>Comment List</h2>
							<hr>
						</header>

					</section>
				</div>
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
<script type="text/javascript">
function showList(flag){
	var joinList = "#dailyJoinList" + flag;

	if($(joinList).is(":visible")){
		$(joinList).slideUp();
	}else{
		$(joinList).slideDown();
	}
};
</script>

</body>
</html>