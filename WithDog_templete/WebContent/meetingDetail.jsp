<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	// 줄바꿈 
	pageContext.setAttribute("br", "<br/>");
	pageContext.setAttribute("cn", "\n");
%>
<!DOCTYPE HTML>
<!--
	Elemental by TEMPLATED
    templated.co @templatedco
    Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>WithDog_meetingDetail</title>
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

<!--댓글 디자인-->
<link rel="stylesheet" href="resources/css/commentCSS/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/commentCSS/style.css" />
<link rel="stylesheet" href="resources/css/commentCSS/style-desktop.css" />
<link rel="stylesheet" href="resources/css/commentCSS/commentStyle.css">

<!--showMap-->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=RQUNwC26q24ETH0hzeGg&submodules=geocoder"></script>
<script type="text/javascript" src="resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/showMap.js"></script>

<!--신고 alert 창-->
<script type="text/javascript">
<script type="text/javascript">
function alertBox() {
	alert('이미 신고된 모임입니다.');
}

function alertBox2() {
	alert('이미 신고된 모임 댓글입니다.');
}
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#reply_save")
								.click(
										function() {
											//널 검사 
											if ($("#content").val().trim() == "") {
												alert("내용을 입력하세요.");
												$("#content").focus();
												return false;
											}
											var content = $("#content").val()
													.replace("\n", "<br>"); //개행처리

											//값 셋팅
											var objParams = {
												parentId : "0",
												depth : "0",
												meetingId : $("#meetingId")
														.val(),
												content : content
											};

											//ajax 호출
											$
													.ajax({
														url : "registMeetingComment.do",
														dataType : "json",
														type : "post",
														data : objParams,
														success : function(
																retVal) {
															location.hash
															window.location
																	.reload(true);
														},
														error : function(
																request,
																status, error) {
															console
																	.log("AJAX_ERROR");
														}
													});

											//댓글 초기화
											$("#content").val("");
										});

						//대댓글 입력창
						$(document)
								.on(
										"click",
										"button[name='reply_reply']",
										function() { //동적 이벤트

											var reply_id = $(this).attr("id");
											var last_check = false;

											$("#reply_add").remove();

											//입력받는 창 등록
											var replyEditor = '<div id="reply_add" class="section1">'
													+ '<div class="reviews">'
													+ '<textarea class="form-control" style="resize: none;" id="reContent" name="reContent" placeholder="댓글을 입력하세요."></textarea>'
													+ '<br>'
													+ '<button class="btn btn-outline-primary" name="reply_reply_save" reply_id="'+reply_id+'">등록</button>'
													+ '&nbsp;&nbsp;'
													+ '<button class="btn btn-outline-primary" name="reply_reply_cancel">취소</button>'
													+ '</div>' + '</div>';

											var prevTr = $(this).parent()
													.parent().next();

											//부모의 부모 다음이 sub이면 마지막 sub 뒤에 붙인다.
											//마지막 리플 처리
											if (prevTr.attr("reply_type") == undefined) {
												prevTr = $(this).parent()
														.parent();
											} else {
												while (prevTr
														.attr("reply_type") == "sub") {//댓글의 다음이 sub면 계속 넘어감
													prevTr = prevTr.next();
												}

												if (prevTr.attr("reply_type") == undefined) {//next뒤에 tr이 없다면 마지막이라는 표시를 해주자
													last_check = true;
												} else {
													prevTr = prevTr.prev();
												}

											}
											prevTr.after(replyEditor);

										});

						//대댓글 등록
						$(document)
								.on(
										"click",
										"button[name='reply_reply_save']",
										function() {

											var reContent = $("textarea[name='reContent']");
											var meetingId = $("input[name='meetingId']");
											var content = reContent.val()
													.replace("\n", "<br>"); //개행처리

											if (content.trim() == "") {
												alert("내용을 입력하세요.");
												content.focus();
												return false;
											}

											//값 셋팅
											var objParams = {
												meetingId : meetingId.val(),
												parentId : $(this).attr(
														"reply_id"),
												depth : "1",
												content : content
											};

											var reply_id;

											//ajax 호출
											$
													.ajax({
														url : "registMeetingComment.do",
														dataType : "json",
														type : "post",
														data : objParams,
														success : function(
																retVal) {

															location.hash
															window.location
																	.reload(true);

														},
														error : function(
																request,
																status, error) {
															console
																	.log("AJAX_ERROR");
														}
													});

										});

						//댓글 삭제
						$("button[name='reply_del']").click(function() {

							var check = false;
							var meetingId = $("input[name='meetingId']");

							//값 셋팅
							var objParams = {
								commentId : $(this).attr("id"),
								parentId : $(this).attr("parentId")
							};

							//ajax 호출
							$.ajax({
								url : "removeMeetingComment.do",
								dataType : "json",
								type : "get",
								data : objParams,
								success : function(retVal) {
									location.hash
									window.location.reload(true);
								},
								error : function(request, status, error) {
									console.log("AJAX_ERROR");
								}
							});

							if (check) {
								//삭제하면서 하위 댓글도 삭제
								var prevTr = $(this).parent().parent().next(); //댓글의 다음

								while (prevTr.attr("reply_type") == "sub") {//댓글의 다음이 sub면 계속 넘어감
									prevTr = prevTr.next();
									prevTr.prev().remove();
								}

								//마지막 리플 처리
								if (prevTr.attr("reply_type") == undefined) {
									prevTr = $(this).parent().parent();
									prevTr.remove();
								}

								$(this).parent().parent().remove();
							}

						});

						//대댓글 입력창 취소
						$(document).on("click",
								"button[name='reply_reply_cancel']",
								function() {
									$("#reply_add").remove();
								});

						//수정
						$(document)
								.on(
										"click",
										"button[name='reply_update']",
										function() { //동적 이벤트

											var reply_id = $(this).attr("id");
											var reply_content = $(this).attr(
													"reply_comment");
											var last_check = false;

											$("#reply_add").remove();

											//입력받는 창 등록
											var replyEditor = '<div id="reply_add" class="section2">'
													+ '<div class="reviews">'
													+ '<textarea class="form-control" style="resize: none;" id="modify" name="modify">'
													+ reply_content
													+ '</textarea>'
													+ '<br>'
													+ '<button class="btn btn-outline-primary" name="reply_reply_update" reply_id="'+reply_id+'">수정</button>'
													+ '&nbsp;&nbsp;'
													+ '<button class="btn btn-outline-primary" name="reply_reply_cancel">취소</button>'
													+ '</div>' + '</div>';

											var prevTr = $(this).parent()
													.parent().next();

											//부모의 부모 다음이 sub이면 마지막 sub 뒤에 붙인다.
											//마지막 리플 처리
											if (prevTr.attr("reply_type") == undefined) {
												prevTr = $(this).parent()
														.parent();
											} else {
												while (prevTr
														.attr("reply_type") == "sub") {//댓글의 다음이 sub면 계속 넘어감
													prevTr = prevTr.next();
												}

												if (prevTr.attr("reply_type") == undefined) {//next뒤에 tr이 없다면 마지막이라는 표시를 해주자
													last_check = true;
												} else {
													prevTr = prevTr.prev();
												}

											}
											prevTr.after(replyEditor);

										});

						//댓글 수정
						$(document)
								.on(
										"click",
										"button[name='reply_reply_update']",
										function() {

											var meetingId = $("input[name='meetingId']");
											var content = $("textarea[name='modify']");

											if (content.val().trim() == "") {
												alert("내용을 입력하세요.");
												content.focus();
												return false;
											}

											//값 셋팅
											var objParams = {
												commentId : $(this).attr(
														"reply_id"),
												content : content.val()
											};

											var reply_id;

											//ajax 호출
											$
													.ajax({
														url : "modifyMeetingComment.do",
														dataType : "json",
														type : "Post",
														data : objParams,
														success : function(
																retVal) {

															location.hash
															window.location
																	.reload(true);

														},
														error : function(
																request,
																status, error) {
															console
																	.log("AJAX_ERROR");
														}
													});

										});

					});
</script>
</head>
<body class="homepage">

	<!-- Header -->
	<%@include file="header.jsp"%>
	<!-- Header -->


	<!-- Main -->
	<div id="main">

		<div class="container">
			<div class="row" style="float: right;">

				<c:choose>
					<c:when test="${loginUser.userId eq 'admin' }">


						<a href="myRemoveMeeting.do?meetingId=${meetingDetail.meetingId }"><img
							src="resources/img/delete.png"
							style="width: 25px; height: auto; vertical-align: right;" alt="">
							<h3>삭제하기</h3></a>
					</c:when>

					<c:when test="${loginUser.userId eq meetingDetail.hostId }">

						<a href="modifyMeeting.do?meetingId=${meetingDetail.meetingId }"><img
							src="resources/img/modify.png"
							style="width: 25px; height: auto; vertical-align: right;" alt="">
							<h3>수정하기</h3></a>
						<a href="removeMeeting.do?meetingId=${meetingDetail.meetingId }"><img
							src="resources/img/delete.png"
							style="width: 25px; height: auto; vertical-align: right;" alt="">
							<h3>삭제하기</h3></a>
					</c:when>


					<c:when test="${loginUser.userId ne meetingDetail.hostId }">

						<c:set value="0" var="check" />

						<c:forEach var="report" items="${meetingReport}">
							<c:if test="${report.reportTargetId eq meetingDetail.meetingId }">
								<c:set value="1" var="check" />
							</c:if>
						</c:forEach>

						<c:choose>

							<c:when test="${check eq 1 }">
								<a href="#" onclick="alertBox(); return false"><img
									src="resources/img/alarm.png"
									style="width: 25px; height: auto; vertical-align: right;"
									alt="">
									<h3>신고하기</h3> </a>
							</c:when>

							<c:otherwise>
								<a
									href="registReport.do?reportTargetId=${meetingDetail.meetingId}&reportType=meeting"><img
									src="resources/img/alarm.png"
									style="width: 25px; height: auto; vertical-align: right;"
									alt="">
									<h3>신고하기</h3> </a>
							</c:otherwise>
						</c:choose>

					</c:when>
				</c:choose>

				<div class="3u"
					style="float: right; margin-right: 35px; width: auto">
					<a href="meetingList.do" class="btn_comm btn_submit form-control"
						style="text-align: center;"> <strong style="color: white">모임목록으로</strong></a>
				</div>
			</div>


			<div class="row">
				<div style="width: 30%; height: 470px;">
					<header>

						<h2 align="left">${meetingDetail.meetingName }</h2>

						<h3 align="left">
							모임 일자 |
							<fmt:formatDate value="${meetingDetail.meetingDate}"
								pattern="yyyy-MM-dd" />
						</h3>
						<h3 align="left">모임 시간 | ${meetingDetail.meetingTime}시</h3>
						<h3 align="left">장소 | ${meetingSpot.spotLocation }</h3>
						<input type="hidden" id="spotAddress"
							value="${meetingSpot.spotLocation }">
						<h3 align="left">모임 목적 | ${meetingDetail.meetingPurpose}</h3>
					</header>
				</div>

				<div id="map" style="width: 67%; height: 470px;"></div>

			</div>

			<section>
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



			<section>

				<div style="border: 2px solid; padding: 10px;">
					<table class="table table-striped table-bordered table-hover">

						<colgroup>
							<col width="800" />
							<col width="300" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">참여 목록</th>
								<th class="text-center">${joinList}</th>
							</tr>
						</thead>


					</table>
				</div>
			</section>

			<section>
				<p></p>
			</section>
		</div>
	</div>

	<div id="mainer">
		<div class="container">
			<div id="post" class="con">
				<div class="hide-comments">
					<input type="checkbox" value="" id="hide-button" name="check"
						checked /> <label for="hide-button" class="button">댓글 숨기기</label>
				</div>

				<div class="comments">
					<c:forEach var="comments" items="${comment}">
						<ul
							reply_type="<c:if test="${comments.depth == '0'}">main</c:if><c:if test="${comments.depth == '1'}">sub</c:if>">
							<li><c:if test="${comments.depth == '1'}">
									<div class="commenter">
										<ul>
											<li>
								</c:if>
								<div class="user-comment">
									<img
										src="https://cdn1.iconfinder.com/data/icons/flat-business-icons/128/user-32.png"
										alt="">
									<header>
										<a href="javascript:void(0)" class="name">${comments.writerId }</a>
										<span>${comments.registDate }</span> &nbsp;&nbsp;&nbsp;
										<c:if test="${comments.depth != '1'}">
											<button class="btn btn-outline-primary" name="reply_reply"
												id="${comments.commentId}">답글 달기</button>
										</c:if>

										<c:choose>

											<c:when test="${loginUser.userId eq 'admin'}">

												<button class="btn btn-primary"
													parentId="${comments.parentId}" id="${comments.commentId}"
													onclick="location.href='removeMeetingComment.do?reportTargetId=${comments.commentId}&reportType=meetingComment'">삭제</button>

											</c:when>


											<c:when test="${loginUser.userId == comments.writerId}">
												<button class="btn btn-outline-primary" name="reply_update"
													reply_comment="${comments.content}"
													id="${comments.commentId}">수정</button>
												<button class="btn btn-primary" name="reply_del"
													parentId="${comments.parentId}" id="${comments.commentId}">삭제</button>
											</c:when>

											<c:when test="${loginUser.userId != comments.writerId }">

												<c:set value="0" var="check" />

												<c:forEach var="report" items="${meetingCommentReport}">
													<c:if
														test="${report.reportTargetId eq comments.commentId }">
														<c:set value="1" var="check" />
													</c:if>
												</c:forEach>

												<c:choose>

													<c:when test="${check eq 1 }">
													
													<button class="btn btn-primary"
													parentId="${comments.parentId}" id="${comments.commentId}"
													onclick="alertBox2(); return false">신고</button>
														
													</c:when>

													<c:otherwise>
														<button class="btn btn-primary"
													parentId="${comments.parentId}" id="${comments.commentId}"
													onclick="location.href='registReport.do?reportTargetId=${comments.commentId}&reportType=meetingComment'">신고</button>
													</c:otherwise>
												</c:choose>



												
											</c:when>


										</c:choose>


									</header>
									<div class="content">
										<p>${fn:replace(comments.content, cn, br)}</p>
										<hr>
									</div>
								</div> <c:if test="${comments.depth == '1'}"></li>
						</ul>
				</div>
				</c:if>

				</li>
				</ul>
				</c:forEach>
			</div>
			<div class="section">
				<div class="reviews">
					<input type="hidden" id="meetingId" name="meetingId"
						value="${meetingDetail.meetingId }"> <input type="hidden"
						id="parentId" name="parentId" value="0"> <input
						type="hidden" id="depth" name="depth" value="0">
					<textarea class="form-control" rows="4" cols="40"
						style="resize: none;" id="content" name="content"
						placeholder="댓글을 입력하세요."></textarea>
					<br>
					<button id="reply_save" class="btn btn-primary" name="reply_save">댓글
						등록</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		$("#hide-button").click(function() {
			if ($(this).is(":checked")) {
				$("label").text("댓글 숨기기");
				$(".comments").slideDown(300);
			} else {
				$("label").text("댓글 펼치기");
				$(".comments").slideUp(300);
			}

		});
		function OnloadImg(url) {
			var img = new Image();
			img.src = url;
			var img_width = img.width;
			var win_width = img.width + 25;
			var height = img.height + 30;
			var OpenWindow = window.open('', '_blank', 'width=' + img_width
					+ ', height=' + height + ', menubars=no, scrollbars=auto');
			OpenWindow.document
					.write("<style>body{margin:0px;}</style><img src='"+url+"' width='"+win_width+"'>");
		}
	</script>
	<!-- /Main -->

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