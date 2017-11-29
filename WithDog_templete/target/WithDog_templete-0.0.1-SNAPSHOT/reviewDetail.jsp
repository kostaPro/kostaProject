<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>With Dog</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
<link rel="stylesheet" href="resources/css/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />

<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
	
	  $(document).ready(function(){
      	//댓글 저장
      	$("#reply_save").click(function(){
      		
            
              var reply_content = $("#content").val().replace("\n", "<br>"); //개행처리
      		
      		//값 셋팅
      		var objParams = {
      				reviewId		: $("#reviewId").val(),
      				spotId			: $("#spotId").val(),
      				writerId		: $("#writerId").val(),
      				reply_content	: reply_content
				};
      		
      		var reply_id;
      		
      		//ajax 호출
      		$.ajax({
      			url			:	"registReviewComment.do",
      			dataType	:	"json",
      			type 		:	"post",
      			async		: 	false, //동기: false, 비동기: ture
      			data		:	objParams,
      			success 	:	function(retVal){

      				if(retVal.code != "OK") {
      					alert(retVal.message);
      				}else{
          				reply_id = retVal.reply_id;
      				}
      				
      			},
      			error		:	function(request, status, error){
      				console.log("AJAX_ERROR");
      			}
      		});
      	});
	  });
   
</script>


</head>
<body class="homepage">

	<!-- Header -->
	<div id="header">
		<div class="container">

			<!-- Logo -->
			<div id="logo">
				<h1>
					<a href="#">WITH DOG</a>
				</h1>
			</div>
		</div>
		<div id="nav-wrapper" class="container">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li class="active"><a href="index.html">Home</a></li>
					<li><a href="left-sidebar.html">Left Sidebar</a></li>
					<li><a href="right-sidebar.html">Right Sidebar</a></li>
					<li><a href="no-sidebar.html">No Sidebar</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
			<div id="banner">
				<a href="#" class="image featured"><img
					src="resources/img/pics11.jpg" alt=""></a>
			</div>
		</div>
	</div>
	<!-- Header -->


	<!-- Main -->
	<div id="main">
		<div class="container">
			<section>
				<header>
					<h2 align="left">${spot.spotName }</h2>

					<h2 align="right">
						<a
							href="modifyReview.do?reviewId=${review.reviewId }&spotId=${spot.spotId}"><button
								class="btn btn-primary" type="button">평가글 수정</button></a> <a
							href="deleteReview.do?reviewId=${review.reviewId }&spotId=${spot.spotId}"><button
								class="btn btn-primary" type="button">평가글 삭제</button></a>
						<button class="btn btn-primary" type="button">평가글 신고</button>
					</h2>
				</header>
				<section>
					<h3 align="left">작성자 | ${review.writerId }</h3>
					<h3 align="left">작성일 | ${review.registDate }</h3>
					<br>
					<div class="row">
						<h3 align="left">제목 | ${review.title }</h3>
					</div>
				</section>
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
				<section>
					<div class="row">
						<section>
							<h3 align="left">[내용]</h3>
							<h3 align="left">${review.content }</h3>
						</section>
					</div>
				</section>
				<table class="table" style="font-size: 14px; padding: 20px;">
					<colgroup>
						<col width="100" />
						<col width="800" />
						<col width="150" />
					</colgroup>
					<c:forEach var="comments" items="${comment}">
						<tr>
							<td class="text-left"><strong>${comments.writerId }</strong></td>
							<td class="text-left">${comments.content }</td>
							<td class="text-right">${comments.registDate }<a href="">수정</a>
								<a href="">삭제</a></td>
						</tr>
					</c:forEach>
					<tr>
					</tr>
				</table>
			</section>
		</div>
		<div class="section">
			<div class="reviews">
				<form action="registReviewComment.do" method="Post">
					<input type="hidden" name="reviewId" value="${review.reviewId }">
					<input type="hidden" name="spotId" value="${spot.spotId }">
					<input type="hidden" name="writerId" value="${user.userId }">
					<textarea class="form-control" id="review" rows="4" cols="40"
						placeholder="댓글을 작성해 주세요." name="content"></textarea>
					<input type="submit" class="btn btn-primary" value="댓글 등록">
				</form>
			</div>
		</div>
		
		
		<table border="1" width="1200px" bordercolor="#46AA46">
   				<tr>
   					<td width="500px">
						이름: <input type="text" id="reply_writer" name="reply_writer" style="width:170px;" maxlength="10" placeholder="작성자"/>
						패스워드: <input type="password" id="reply_password" name="reply_password" style="width:170px;" maxlength="10" placeholder="패스워드"/>
						<button id="reply_save" name="reply_save">댓글 등록</button>
					</td>
   				</tr>
   				<tr>
   					<td>
   					<input type="hidden" name="reviewId" value="${review.reviewId }">
					<input type="hidden" name="spotId" value="${spot.spotId }">
					<input type="hidden" name="writerId" value="${user.userId }">
   						<textarea id="reply_content" name="content" rows="4" cols="50" placeholder="댓글을 입력하세요."></textarea>
   					</td>
   				</tr>
   			</table>
		
		
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