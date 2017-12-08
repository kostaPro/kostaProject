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
<title>WithDog_Admin_ReportList</title>
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

<!--
Tab -->ul.tabs {
	margin: 0;
	padding: 0;
	float: left;
	list-style: none;
	height: 32px;
	border-bottom: 1px solid #eee;
	border-left: 1px solid #eee;
	width: 100%;
	font-family: "dotum";
	font-size: 12px;
}

ul.tabs li {
	float: left;
	text-align: center;
	cursor: pointer;
	width: 82px;
	height: 31px;
	line-height: 31px;
	border: 1px solid #eee;
	border-left: none;
	font-weight: bold;
	background: #fafafa;
	overflow: hidden;
	position: relative;
}

ul.tabs li.active {
	background: #FFFFFF;
	border-bottom: 1px solid #FFFFFF;
}

.tab_container {
	border: 1px solid #eee;
	border-top: none;
	clear: both;
	float: left;
	width: 1000px;
	background: #FFFFFF;
}

.tab_content {
	padding: 5px;
	font-size: 12px;
	display: none;
}

.tab_container .tab_content ul {
	width: 100%;
	margin: 0px;
	padding: 0px;
}

.tab_container .tab_content ul li {
	padding: 5px;
	list-style: none
}

;
#container {
	width: 249px;
	margin: 0 auto;
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
								<font size="6" color="#000000"><b>신고 구분 별 조회</b></font>
								<hr>
							</header>

						</section>



						<div id="container">
							<ul class="tabs">
								<li class="active" rel="tab1">모임</li>
								<li rel="tab2">장소</li>
								<li rel="tab3">평가글</li>
								<li rel="tab4">댓글</li>
							</ul>

							<div class="tab_container">
								<div id="tab1" class="tab_content">
									<table class="table table-striped table-bordered table-hover">

										<colgroup>
											<col width="200" />
											<col width="700" />
											<col width="100" />
											<col width="100" />


										</colgroup>
										<thead>
											<tr>
												<th class="text-center">신고 대상</th>
												<th class="text-center">신고 사유</th>
												<th class="text-center">처리 상태</th>
												<th class="text-center"></th>
											</tr>
										</thead>
										<tbody>

											<c:choose>
												<c:when test="${empty meetingReport }">
													<tr>
														<th colspan="4 " class="text-center">신고가 존재하지 않습니다.</th>
													</tr>
												</c:when>

												<c:otherwise>

													<c:forEach var="meetingReport" items="${meetingReport }">

														<tr>
															<form action="modifyReport.do">
																<td class="text-center">${meetingReport.reportTargetId }</td>
																<td class="text-center">${meetingReport.reportContent }</td>

																<td class="text-center"><select name="status"
																	id="status">
																		<option>${meetingReport.status }</option>

																		<option value="O">경고</option>
																		<option value="X">미경고</option>
																</select></td>

																<td><input type="hidden" name="reportType"
																	value="meeting"><input type="hidden"
																	name="reportTargetId"
																	value="${meetingReport.reportTargetId }"> <input
																	type="submit" value="수정"
																	class="btn btn-primary btn-block form-control"
																	id="search_btn"
																	style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">

																</td>
															</form>
														</tr>

													</c:forEach>
												</c:otherwise>
											</c:choose>

										</tbody>

									</table>
								</div>
								<!-- #tab1 -->



								<div id="tab2" class="tab_content">
									<div>
										<input type="hidden" name="reportType" value="spot">
										<table class="table table-striped table-bordered table-hover">

											<colgroup>
												<col width="200" />
												<col width="700" />
												<col width="100" />
												<col width="100" />


											</colgroup>
											<thead>
												<tr>

													<th class="text-center">신고 대상</th>
													<th class="text-center">신고 사유</th>
													<th class="text-center">처리 상태</th>
													<th class="text-center"></th>
												</tr>
											</thead>
											<tbody>

												<c:choose>
													<c:when test="${empty spotReport }">
														<tr>
															<th colspan="4 " class="text-center">신고가 존재하지 않습니다.</th>
														</tr>
													</c:when>

													<c:otherwise>

														<c:forEach var="spotReport" items="${spotReport }">

															<tr>
																<form action="modifyReport.do">
																	<td class="text-center">${spotReport.reportTargetId }</td>
																	<td class="text-center">${spotReport.reportContent }</td>

																	<td class="text-center"><select name="status"
																		id="status">
																			<option>${spotReport.status }</option>

																			<option value="O">경고</option>
																			<option value="X">미경고</option>
																	</select></td>

																	<td><input type="hidden" name="reportType"
																		value="spot"> <input type="hidden"
																		name="reportTargetId"
																		value="${spotReport.reportTargetId }"> <input
																		type="submit" value="수정"
																		class="btn btn-primary btn-block form-control"
																		id="search_btn"
																		style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">

																	</td>
																</form>
															</tr>

														</c:forEach>
													</c:otherwise>
												</c:choose>

											</tbody>

										</table>

									</div>
								</div>
								<!-- #tab2 -->



								<div id="tab3" class="tab_content">

									<div>
										<input type="hidden" name="reportType" value="review">
										<table class="table table-striped table-bordered table-hover">

											<colgroup>
												<col width="200" />
												<col width="700" />
												<col width="100" />
												<col width="100" />


											</colgroup>
											<thead>
												<tr>

													<th class="text-center">신고 대상</th>
													<th class="text-center">신고 사유</th>
													<th class="text-center">처리 상태</th>
													<th class="text-center"></th>
												</tr>
											</thead>
											<tbody>

												<c:choose>
													<c:when test="${empty reviewReport }">
														<tr>
															<th colspan="4" class="text-center">신고가 존재하지 않습니다.</th>
														</tr>
													</c:when>

													<c:otherwise>

														<c:forEach var="reviewReport" items="${reviewReport }">

															<tr>
																<form action="modifyReport.do">
																	<td class="text-center">${reviewReport.reportTargetId }</td>
																	<td class="text-center">${reviewReport.reportContent }</td>

																	<td class="text-center"><select name="status"
																		id="status">
																			<option>${reviewReport.status }</option>

																			<option value="O">경고</option>
																			<option value="X">미경고</option>
																	</select></td>

																	<td><input type="hidden" name="reportType"
																		value="review"> <input type="hidden"
																		name="reportTargetId"
																		value="${reviewReport.reportTargetId }"> <input
																		type="submit" value="수정"
																		class="btn btn-primary btn-block form-control"
																		id="search_btn"
																		style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">

																	</td>
																</form>
															</tr>

														</c:forEach>
													</c:otherwise>
												</c:choose>

											</tbody>

										</table>

									</div>

								</div>
								<!-- #tab3 -->


								<div id="tab4" class="tab_content">

									<!-- 이벤트 댓글 -->
									<div>
										<div style="float:left;">
											<font size="2" color="#5D5D5D"><b>이벤트 댓글</b></font>	
										</div>

										<input type="hidden" name="reportType" value="eventComment">
										<table class="table table-striped table-bordered table-hover">

											<colgroup>
												<col width="200" />
												<col width="700" />
												<col width="100" />
												<col width="100" />


											</colgroup>
											<thead>
												<tr>

													<th class="text-center">신고 대상</th>
													<th class="text-center">신고 사유</th>
													<th class="text-center">처리 상태</th>
													<th class="text-center"></th>
												</tr>
											</thead>
											<tbody>

												<c:choose>
													<c:when test="${empty commentReport }">
														<tr>
															<th colspan="4" class="text-center">신고가 존재하지 않습니다.</th>
														</tr>
													</c:when>

													<c:otherwise>

														<c:forEach var="eventCommentReport"
															items="${eventCommentReport }">

															<tr>
																<form action="modifyReport.do">
																	<td class="text-center">${eventCommentReport.reportTargetId }</td>
																	<td class="text-center">${eventCommentReport.reportContent }</td>

																	<td class="text-center"><select name="status"
																		id="status">
																			<option>${eventCommentReport.status }</option>

																			<option value="O">경고</option>
																			<option value="X">미경고</option>
																	</select></td>

																	<td><input type="hidden" name="reportType"
																		value="eventCommentReport"> <input
																		type="hidden" name="reportTargetId"
																		value="${eventCommentReport.reportTargetId }">
																		<input type="submit" value="수정"
																		class="btn btn-primary btn-block form-control"
																		id="search_btn"
																		style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">

																	</td>
																</form>
															</tr>

														</c:forEach>
													</c:otherwise>
												</c:choose>

											</tbody>

										</table>

									</div>

									
									<!-- 모임 댓글 -->
									<div>
									<div style="float:left;">
											<font size="2" color="#5D5D5D"><b>모임 댓글</b></font>	
										</div>

										<input type="hidden" name="reportType"
											value="meetingCommentReport">
										<table class="table table-striped table-bordered table-hover">

											<colgroup>
												<col width="200" />
												<col width="700" />
												<col width="100" />
												<col width="100" />


											</colgroup>
											<thead>
												<tr>

													<th class="text-center">신고 대상</th>
													<th class="text-center">신고 사유</th>
													<th class="text-center">처리 상태</th>
													<th class="text-center"></th>
												</tr>
											</thead>
											<tbody>

												<c:choose>
													<c:when test="${empty meetingCommentReport }">
														<tr>
															<th colspan="4" class="text-center">신고가 존재하지 않습니다.</th>
														</tr>
													</c:when>

													<c:otherwise>

														<c:forEach var="meetingCommentReport"
															items="${meetingCommentReport }">

															<tr>
																<form action="modifyReport.do">
																	<td class="text-center">${meetingCommentReport.reportTargetId }</td>
																	<td class="text-center">${meetingCommentReport.reportContent }</td>

																	<td class="text-center"><select name="status"
																		id="status">
																			<option>${meetingCommentReport.status }</option>

																			<option value="O">경고</option>
																			<option value="X">미경고</option>
																	</select></td>

																	<td><input type="hidden" name="reportType"
																		value="meetingCommentReport"> <input
																		type="hidden" name="reportTargetId"
																		value="${meetingCommentReport.reportTargetId }">
																		<input type="submit" value="수정"
																		class="btn btn-primary btn-block form-control"
																		id="search_btn"
																		style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">

																	</td>
																</form>
															</tr>

														</c:forEach>
													</c:otherwise>
												</c:choose>

											</tbody>

										</table>

									</div>
									
									<!-- 평가글 댓글 -->
									<div>
									<div style="float:left;">
											<font size="2" color="#5D5D5D"><b>평가글 댓글</b></font>	
										</div>

										<input type="hidden" name="reportType"
											value="reviewCommentReport">
										<table class="table table-striped table-bordered table-hover">

											<colgroup>
												<col width="200" />
												<col width="700" />
												<col width="100" />
												<col width="100" />


											</colgroup>
											<thead>
												<tr>

													<th class="text-center">신고 대상</th>
													<th class="text-center">신고 사유</th>
													<th class="text-center">처리 상태</th>
													<th class="text-center"></th>
												</tr>
											</thead>
											<tbody>

												<c:choose>
													<c:when test="${empty reviewCommentReport }">
														<tr>
															<th colspan="4" class="text-center">신고가 존재하지 않습니다.</th>
														</tr>
													</c:when>

													<c:otherwise>

														<c:forEach var="reviewCommentReport"
															items="${reviewCommentReport }">

															<tr>
																<form action="modifyReport.do">
																	<td class="text-center">${reviewCommentReport.reportTargetId }</td>
																	<td class="text-center">${reviewCommentReport.reportContent }</td>

																	<td class="text-center"><select name="status"
																		id="status">
																			<option>${reviewCommentReport.status }</option>

																			<option value="O">경고</option>
																			<option value="X">미경고</option>
																	</select></td>

																	<td><input type="hidden" name="reportType"
																		value="reviewCommentReport"> <input
																		type="hidden" name="reportTargetId"
																		value="${reviewCommentReport.reportTargetId }">
																		<input type="submit" value="수정"
																		class="btn btn-primary btn-block form-control"
																		id="search_btn"
																		style="color: #fff !important; background: #43becc; border: 1px solid #43becc !important;">

																	</td>
																</form>
															</tr>

														</c:forEach>
													</c:otherwise>
												</c:choose>

											</tbody>

										</table>

									</div>
									


								</div>
								<!-- #tab4 -->


							</div>
							<!-- .tab_container -->
						</div>
						<!-- #container -->


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


<script type="text/javascript">
	$(function() {

		$(".tab_content").hide();
		$(".tab_content:first").show();

		$("ul.tabs li").click(function() {
			$("ul.tabs li").removeClass("active").css("color", "#333");
			//$(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
			$(this).addClass("active").css("color", "#ABABAB");
			$(".tab_content").hide()
			var activeTab = $(this).attr("rel");
			$("#" + activeTab).fadeIn()
		});
	});
</script>
</html>

