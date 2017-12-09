<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	// 줄바꿈 
	pageContext.setAttribute("br", "<br/>");
	pageContext.setAttribute("cn", "\n");
%>
<!DOCTYPE HTML>
<html>
<head>
<title>With Dog</title>
<link rel='stylesheet prefetch'
	href='resources/css/commentCSS/bootstrapcomment.css'>
<link rel="stylesheet" href="resources/css/commentCSS/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/commentCSS/style.css" />
<link rel="stylesheet" href="resources/css/commentCSS/style-desktop.css" />

<link rel="stylesheet" href="resources/css/commentCSS/commentStyle.css">
<script src="https://code.jquery.com/jquery-2.2.3.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#reply_save").click(
								function() {
									//널 검사 
									if ($("#content").val().trim() == "") {
										alert("내용을 입력하세요.");
										$("#content").focus();
										return false;
									}
									var content = $("#content").val().replace(
											"\n", "<br>"); //개행처리

									//값 셋팅
									var objParams = {
										parentId : "0",
										depth : "0",
										reviewId : $("#reviewId").val(),
										spotId : $("#spotId").val(),
										content : content
									};

									//ajax 호출
									$
											.ajax({
												url : "registReviewComment.do",
												dataType : "json",
												type : "post",
												data : objParams,
												success : function(retVal) {
													location.hash
													window.location
															.reload(true);
												},
												error : function(request,
														status, error) {
													console.log("AJAX_ERROR");
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
											var spotId = $("input[name='spotId']");
											var reviewId = $("input[name='reviewId']");
											var content = reContent.val()
													.replace("\n", "<br>"); //개행처리

											if (content.trim() == "") {
												alert("내용을 입력하세요.");
												content.focus();
												return false;
											}

											//값 셋팅
											var objParams = {
												reviewId : reviewId.val(),
												parentId : $(this).attr(
														"reply_id"),
												depth : "1",
												spotId : spotId.val(),
												content : content
											};

											var reply_id;

											//ajax 호출
											$.ajax({
												url : "registReviewComment.do",
												dataType : "json",
												type : "post",
												data : objParams,
												success : function(retVal) {

													location.hash
													window.location
															.reload(true);

												},
												error : function(request,
														status, error) {
													console.log("AJAX_ERROR");
												}
											});

										});

						//댓글 삭제
						$("button[name='reply_del']").click(function() {

							var check = false;
							var spotId = $("input[name='spotId']");
							var reviewId = $("input[name='reviewId']");

							//값 셋팅
							var objParams = {
								commentId : $(this).attr("id"),
								parentId : $(this).attr("parentId")
							};

							//ajax 호출
							$.ajax({
								url : "removeReviewComment.do",
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
						$(document).on(
								"click",
								"button[name='reply_reply_update']",
								function() {

									var spotId = $("input[name='spotId']");
									var reviewId = $("input[name='reviewId']");
									var content = $("textarea[name='modify']");

									if (content.val().trim() == "") {
										alert("내용을 입력하세요.");
										content.focus();
										return false;
									}

									//값 셋팅
									var objParams = {
										commentId : $(this).attr("reply_id"),
										content : content.val()
									};

									var reply_id;

									//ajax 호출
									$
											.ajax({
												url : "modifyReviewComment.do",
												dataType : "json",
												type : "Post",
												data : objParams,
												success : function(retVal) {

													location.hash
													window.location
															.reload(true);

												},
												error : function(request,
														status, error) {
													console.log("AJAX_ERROR");
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
	<div id="mainer">
		<div class="container">
			<div id="post" class="con">
				<header>

					<h2 align="center">${review.title }</h2>
					<div class="row">
						<p>
							<span>[ 작성자 | ${review.writerId } ]</span> <a
								href="spotDetail.do?spotId=${spot.spotId }"><span>[
									장소명 | ${spot.spotName } ]</span></a> <span>[ 작성일 |
								${review.registDate } ]</span>
						</p>
					</div>


					<h2 align="right">
						<c:choose>

							<c:when test="${loginUser.userId eq 'admin' }">

								<a
									href="removeReviewComment.do?reviewId=${review.reviewId }&spotId=${spot.spotId}">
									<button class="btn btn-primary" type="button">평가글 삭제</button>
								</a>
							</c:when>

							<c:when test="${loginUser.userId eq review.writerId }">
								<a
									href="modifyReview.do?reviewId=${review.reviewId }&spotId=${spot.spotId}">
									<button class="btn btn-primary" type="button">평가글 수정</button>
								</a>
								<a
									href="deleteReview.do?reviewId=${review.reviewId }&url=spotDetail.do?spotId=${spot.spotId}"> 
									<button class="btn btn-primary" type="button">평가글 삭제</button>
								</a>
							</c:when>
							
							<c:otherwise>

								<a
									href="registReport.do?reportTargetId=${review.reviewId}&reportType=review">
									<button class="btn btn-primary" type="button">평가글 신고</button>
								</a>

							</c:otherwise>

						</c:choose>
					</h2>
				</header>
				<br> <br>

				<div class="row">
					<c:forEach var="uploadFile" items="${uploadFileList}">
						<div class="4u">
							<section>
								<img class="imgs" src="/images/${uploadFile}" />
							</section>
						</div>
					</c:forEach>
				</div>
				<br>
				<div class="section">
					<div class="reviews">
						<textarea class="form-control" rows="15" cols="20"
							style="resize: none;" disabled="disabled">${review.content }</textarea>
					</div>
				</div>

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
									<img src="/images/${loginUser.petImage }"
										onclick="OnloadImg(this.src)">
									<header>
										<a class="name">${comments.writerId }</a> <span>${comments.registDate }</span>
										&nbsp;&nbsp;&nbsp;
										<c:if test="${comments.depth != '1'}">
											<button class="btn btn-outline-primary" name="reply_reply"
												id="${comments.commentId}">답글 달기</button>
										</c:if>
										<c:choose>
											<c:when test="${loginUser.userId eq 'admin' }">

												<button class="btn btn-primary" name="reply_del"
													parentId="${comments.parentId}" id="${comments.commentId}">삭제</button>

											</c:when>


											<c:when test="${loginUser.userId == comments.writerId}">
												<button class="btn btn-outline-primary" name="reply_update"
													reply_comment="${comments.content}"
													id="${comments.commentId}">수정</button>
												<button class="btn btn-primary" name="reply_del"
													parentId="${comments.parentId}" id="${comments.commentId}">삭제</button>
											</c:when>


											<c:when test="${loginUser.userId != comments.writerId }">

												<button class="btn btn-primary"
													parentId="${comments.parentId}" id="${comments.commentId}"
													onclick="location.href='registReport.do?reportTargetId=${comments.commentId}&reportType=reviewComment'">신고</button>
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
					<input type="hidden" id="reviewId" name="reviewId"
						value="${review.reviewId }"> <input type="hidden"
						id="spotId" name="spotId" value="${spot.spotId }"> <input
						type="hidden" id="parentId" name="parentId" value="0"> <input
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
					.write("_$tag__body{margin:0px;}_$tag____$tag____________________________________");
		}
	</script>
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