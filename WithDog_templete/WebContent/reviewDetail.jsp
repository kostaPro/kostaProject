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
	$(document)
			.ready(
					function() {
						//댓글 저장
						$("#reply_save")
								.click(
										function() {
											//널 검사 
											if ($("#content").val().trim() == "") {
												alert("내용을 입력하세요.");
												$("#content").focus();
												return false;
											}
											var content = $("#content").val().replace("\n", "<br>"); //개행처리
											
											//값 셋팅
											var objParams = {
												parentId : "0",
												depth : "0",
												reviewId : $("#reviewId").val(),
												spotId : $("#spotId").val(),
												writerId : $("#writerId").val(),
												content : content
											};

											//ajax 호출
											$
													.ajax({
														url : "registReviewComment.do",
														dataType : "json",
														type : "post",
														data : objParams,
														async : false,
														success : function(
																retVal) {

														},
														error : function(
																request,
																status, error) {
															console
																	.log("AJAX_ERROR");
														}
													});
						            		
											var writerId = $("input[name='writerId']");
											var registDate = $("input[name='registDate']");
											var commentId = $("input[name='commentId']");
											
											var reply_area = $("#reply_area");
											
						            		var reply = 
						            			'<tr reply_type="main">'+
							            		'	<td class="text-left">'+
							            		'<strong>'+writerId.val()+'</strong>'+
							            		'	</td>'+
							            		'	<td class="text-left">'+
							            		''+content+''+
							            		'	</td>'+
							            		'	<td class="text-right">'+
							            		''+registDate.val()+''+
							            		'	</td>'+
							            		'<td>'+
							            		'<button class="btn btn-outline-primary" name="reply_reply" reply_id = "'+commentId.val()+'">답글 달기</button>'+
							            		'	</td>'+
							            		'<td>'+
							            		'<button id="reply_update" class="btn btn-outline-primary" name="reply_update">수정</button>'+
							            		'</td>'+
							            		'<td>'+
							            		'<button id="reply_del" class="btn btn-primary" name="reply_del">삭제</button>'+
							            		'</tr>';

						            		 if($('#reply_area').contents().size()==0){
						                         $('#reply_area').append(reply);
						                     }else{
						                         $('#reply_area tr:last').after(reply);
						                     }

						            		//댓글 초기화
						            		 $("#content").val("");
										});

						
						 //대댓글 입력창
		                $(document).on("click","button[name='reply_reply']",function(){ //동적 이벤트
		                     
		                    $("#reply_add").remove();
		                     
		                    var reply_id = $(this).attr("reply_id");
		                    var last_check = false;//마지막 tr 체크
		                     
		                    var writerId = $("input[name='writerId']");
							var registDate = $("input[name='registDate']");
							
		                    //입력받는 창 등록
		                     var replyEditor = 
		                        '<tr id="reply_add" class="reply_reply">'+
		                        '<td>'+
		                        '<strong>'+writerId.val()+'</strong>'+
		                        '</td>'+
		                        '<td>'+
		                        '<textarea class="form-control" rows="4" cols="80" name="reContent" style="resize: none;" ></textarea>'+
		                        '</td>'+
		                        '<td>'+
		                        '<button class="btn btn-outline-primary" name="reply_reply_save" reply_id="'+reply_id+'">등록</button>'+
		                        '<br>'+
		                        '<br>'+
		                        '<button class="btn btn-outline-primary" name="reply_reply_cancel">취소</button>'+
		                        '</td>'+
		                        '</tr>';

		                    var prevTr = $(this).parent().parent().next();
		                     
		                    //부모의 부모 다음이 sub이면 마지막 sub 뒤에 붙인다.
		                    //마지막 리플 처리
		                    if(prevTr.attr("reply_type") == undefined){
		                        prevTr = $(this).parent().parent();
		                    }else{
		                        while(prevTr.attr("reply_type")=="sub"){//댓글의 다음이 sub면 계속 넘어감
		                            prevTr = prevTr.next();
		                        }
		                         
		                        if(prevTr.attr("reply_type") == undefined){//next뒤에 tr이 없다면 마지막이라는 표시를 해주자
		                            last_check = true;
		                        }else{
		                            prevTr = prevTr.prev();
		                        }
		                         
		                    }
		                     
		                    if(last_check){//마지막이라면 제일 마지막 tr 뒤에 댓글 입력을 붙인다.
		                        $('#reply_area tr:last').after(replyEditor);    
		                    }else{
		                        prevTr.after(replyEditor);
		                    }
		                     
		                });
						 
		              //대댓글 등록
		                $(document).on("click","button[name='reply_reply_save']",function(){
		                                         

		                    var reContent = $("textarea[name='reContent']");
		                    var writerId = $("input[name='writerId']");
		                    var spotId = $("input[name='spotId']");
		                    var reviewId = $("input[name='reviewId']");
							var registDate = $("input[name='registDate']");
							var commentId = $("input[name='commentId']");
							var content = reContent.val().replace("\n", "<br>"); //개행처리

		                    if(reContent.val().trim() == ""){
		                        alert("내용을 입력하세요.");
		                        reContent.focus();
		                        return false;
		                    }

		                    //값 셋팅
		                    var objParams = {	               
		                            reviewId        : reviewId.val(),
		                            parentId        : $(this).attr("reply_id"), 
		                            depth           : "1",
		                            writerId    : writerId.val(),
		                            spotId : spotId.val(),
		                            content : reContent.val()
		                    };
		                     
		                    var reply_id;
		                     
		                    //ajax 호출
		                    $.ajax({
		                    	url : "registReviewComment.do",
								dataType : "json",
								type : "post",
								async		: 	false,
								data : objParams,
		                        success     :   function(retVal){
		                        
		                        },
		                        error       :   function(request, status, error){
		                            console.log("AJAX_ERROR");
		                        }
		                    });
		                     
		                    var reply = 
		                        '<tr reply_type="sub">'+
		                		'<td class="text-left">'+
			            		'	</td>'+
			            		'	<td class="text-left">'+
			            		'→ <strong>'+writerId.val()+'</strong>'+
			            		'<br>'+
			            		''+content+''+
			            		'	</td>'+
			            		'	<td class="text-right">'+
			            		''+registDate.val()+''+
			            		'	</td>'+
			            		'	<td>'+
			            		'	</td>'+
			            		'<td>'+
			            		'<button id="reply_update" class="btn btn-outline-primary" name="reply_update">수정</button>'+
			            		'</td>'+
			            		'<td>'+
			            		'<button id="reply_del" class="btn btn-primary" name="reply_del">삭제</button>'+
			            		'</tr>';

		                    var prevTr = $(this).parent().parent().prev();
		                     
		                    prevTr.after(reply);
		                                         
		                    $("#reply_add").remove();
		                     
		                });
						 
		              
		              
		              
		              //댓글 삭제
		                $("button[name='reply_del']").click(function(){
		                     
		                    var check = false;

		                    //값 셋팅
		                    var objParams = {
		                            commentId : $(this).attr("reply_id")
		                    };
		                     
		                    //ajax 호출
		                    $.ajax({
		                        url         :   "removeReviewComment.do",
		                        dataType    :   "json",
		                        type        :   "Get",
		                        async		: 	false,
		                        data        :   objParams,
		                        success     :   function(retVal){
		 
		                        },
		                        error       :   function(request, status, error){
		                            console.log("AJAX_ERROR");
		                        }
		                    });
		                     
		                    if(check){
		                        //삭제하면서 하위 댓글도 삭제
		                        var prevTr = $(this).parent().parent().next(); //댓글의 다음
		                         
		                        while(prevTr.attr("reply_type")=="sub"){//댓글의 다음이 sub면 계속 넘어감
		                            prevTr = prevTr.next();
		                            prevTr.prev().remove();
		                        }
		                         
		                        //마지막 리플 처리
		                        if(prevTr.attr("reply_type") == undefined){
		                            prevTr = $(this).parent().parent();
		                            prevTr.remove();
		                        }
		                         
		                        $(this).parent().parent().remove(); 
		                    }
		                     
		                });
						 
		              
		             	
						
		            	//대댓글 입력창 취소
		            	$(document).on("click","button[name='reply_reply_cancel']",function(){
		            		$("#reply_add").remove();
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
				

   			<table class="table" style="font-size: 14px; padding: 20px;" id="reply_area">
   				<colgroup>
						<col width="100" />
						<col width="800" />
						<col width="150" />
				</colgroup>
				<tr reply_type="all"><!-- 뒤에 댓글 붙이기 쉽게 선언 -->
   					<td colspan="4"></td>
   				</tr>
	   			<!-- 댓글이 들어갈 공간 -->
	   			<c:forEach var="comments" items="${comment}">
	   			<input type="hidden" id="comment" name="comment" value="${comment}">
					<tr reply_type="<c:if test="${comments.depth == '0'}">main</c:if><c:if test="${comments.depth == '1'}">sub</c:if>"><!-- 댓글의 depth 표시 -->
			    		<td class="text-left">
			    			<c:if test="${comments.depth == '0'}"><strong>${comments.writerId }</strong></c:if>
			    			<c:if test="${comments.depth == '1'}"></c:if>
			    		</td>
			    		<td class="text-left"><c:if test="${comments.depth == '1'}"> → <strong>${comments.writerId }</strong><br>${comments.content }</c:if>
			    		<c:if test="${comments.depth == '0'}">${comments.content }</c:if>
			    		</td>
			    		<td class="text-right">
			    		<input type="hidden" id="registDate" name="registDate" value="${comments.registDate }">${comments.registDate }</td>
			    		
			    		<td>
			    			<c:if test="${comments.depth != '1'}">
			    			<input type="hidden" id="commentId" name="commentId" value="${comments.commentId }">
			    			<input type="hidden" id="parentId" name="parentId" value="${comments.parentId }">
			    				<button class="btn btn-outline-primary" name="reply_reply" reply_id = "${comments.commentId}">답글 달기</button><!-- 첫 댓글에만 댓글이 추가 대댓글 불가 -->
			    			</c:if>
			    		</td>
			    		 <c:if test="${user.userId == comments.writerId}">
			    		<td>
			    		<button id="reply_update" class="btn btn-outline-primary" name="reply_update">수정</button></td>
					<td><a href="removeReviewComment.do?commentId=${comments.commentId}&reviewId=${review.reviewId }&spotId=${spot.spotId}">
					<button id="reply_del" class="btn btn-primary" name="reply_del">삭제</button></a></td></c:if>
			    	</tr>
			    </c:forEach>
   			</table>
   		

			</section>
		</div>

		<div class="section">
			<div class="reviews">
				<input type="hidden" id="reviewId" name="reviewId"
					value="${review.reviewId }"> <input type="hidden"
					id="spotId" name="spotId" value="${spot.spotId }"> <input
					type="hidden" id="writerId" name="writerId" value="${user.userId }">
				<textarea class="form-control" rows="4" cols="40" style="resize: none;" id="content"
					name="content" placeholder="댓글을 입력하세요."></textarea>
				<button id="reply_save" class="btn btn-primary" name="reply_save">댓글
					등록</button>
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