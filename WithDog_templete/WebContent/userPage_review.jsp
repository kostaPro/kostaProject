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


<style>
.pp input,
.pp select { float:left; margin:0 10px;  width:33%;}
.pp { content:""; display:block; clear:both;}
.pp input:last-of-type { width:100px; color:#fff; background:#43becc; border:1px solid #43becc;}
.text-center{ width:100px;}
.text-ss{ width:10%; text-align: center;}
</style>


<script src="https://code.jquery.com/jquery-2.2.3.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
$(document)
								.on(
										"click",
										"button[name='modify']",
										function() {

											var review_id = $(this).attr("id");
											var review_title = $(this).attr(
													"review_title");
											var review_content = $(this).attr(
											"review_content");
											var last_check = false;

											$("#reply_add").remove();

											var replyEditor = 
													'<tr id="reply_add">'
													+ '<td colspan="4">'
													+ '<h3 align="left">제목</h3>'
													+ '<textarea class="form-control" style="resize: none;" name="title">'
													+ review_title
													+ '</textarea>'
													+ '<br>'
													+ '<h3 align="left">내용</h3>'
													+ '<textarea class="form-control" style="resize: none;" name="content">'
													+ review_content
													+ '</textarea>'
													+ '<br>'
													+ '<button class="btn btn-outline-primary" name="review_update" review_id="'+review_id+'">수정</button>'
													+ '&nbsp;&nbsp;'
													+ '<button class="btn btn-outline-primary" name="review_cancel">취소</button>'
													+ '</td>' + '</tr>';

											var prevTr = $(this).parent()
													.parent().next();

											if (prevTr.attr("reply_type") == undefined) {
												prevTr = $(this).parent()
														.parent();
											} else {
												while (prevTr
														.attr("reply_type") == "sub") {
													prevTr = prevTr.next();
												}

												if (prevTr.attr("reply_type") == undefined) {
													last_check = true;
												} else {
													prevTr = prevTr.prev();
												}

											}
											prevTr.after(replyEditor);

										});
										
						$(document).on("click",
							"button[name='review_cancel']",
							function() {
								$("#reply_add").remove();
								});

			
						$(document).on(
								"click",
								"button[name='review_update']",
								function() {

									var title = $("textarea[name='title']");
									var content = $("textarea[name='content']");

									if (content.val().trim() == "" && title.val().trim()) {
										alert("내용을 입력하세요.");
										content.focus();
										return false;
									}

								
									var objParams = {
										reviewId : $(this).attr("review_id"),
										content : content.val(),
										title : title.val()
									};

									var review_id;

								
									$
											.ajax({
												url : "myModifyReview.do",
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
	<div id="main">

		<div class="container">
			<div class="row">
		<%@include file="myPage_user.jsp"%>
			<div id="content" class="9u skel-cell-important">
					<section>
						<section>
							<header>
								<font size="3" color="#000000"><b>내 평가글</b></font>
								<hr>
							</header>

						</section>



						<table class="table table-striped table-bordered table-hover">
							<colgroup>
								<col width="100" />
								<col width="300" />
								<col width="400" />
								<col width="100" />
								<col width="100" />
							</colgroup>
							<thead>
								<tr>
									<th class="text-center">작성일</th>
									<th class="text-center">제목</th>
									<th class="text-ss">수정</th>
									<th class="text-ss">삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty myReview }">
										<tr>
											<th colspan="4 " class="text-center">작성한 평가글이 존재하지 않습니다.</th>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="myReview" items="${myReview }">
											<tr>
												
												<td class="text-center"><fmt:formatDate value="${myReview.registDate}" pattern="yyyy-MM-dd" /></td>
												<td class="text-center"><a href="reviewDetail.do?reviewId=${myReview.reviewId }&spotId=${myReview.spotId}">${myReview.title }</a></td>
												
												<td><button name="modify" style="border: none; background-color: transparent;" review_title="${myReview.title}" review_content="${myReview.content }"
													id="${myReview.reviewId}"><img src="resources/img/modify.png" style="width: 25px; height: auto; vertical-align:right;" alt=""></button></td>
												<td><a href="deleteReview.do?reviewId=${myReview.reviewId }&url=userPage_review.do"><img src="resources/img/delete.png" style="width: 25px; height: auto; vertical-align:right;" alt=""></a></td>
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