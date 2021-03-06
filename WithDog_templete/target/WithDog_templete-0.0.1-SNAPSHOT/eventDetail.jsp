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

<!--참여 목록 접기를 위한 jQuery추가 -->
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>

<!--참여 목록 접기-->
<script type="text/javascript" src="resources/js/spreadJoinList.js"></script>


<link rel="stylesheet" href="resources/css/commentCSS/skel-noscript.css" /> 
<link rel="stylesheet" href="resources/css/commentCSS/style.css" />
<link rel="stylesheet" href="resources/css/commentCSS/style-desktop.css" />
<link rel="stylesheet" href="resources/css/commentCSS/commentStyle.css"> 

<script src="https://code.jquery.com/jquery-2.2.3.js"></script>

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
									var content = $("#content").val().replace("\n", "<br>"); //개행처리
									
									//값 셋팅
									var objParams = {
										parentId : "0",
										depth : "0",
										eventId : $("#eventId").val(),
										content : content
									};


									//ajax 호출
									$
											.ajax({
												url : "registEventComment.do",
												dataType : "json",
												type : "post",
												data : objParams,
												success : function(
														retVal) {
													location.hash
													window.location.reload(true);
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
		                $(document).on("click","button[name='reply_reply']",function(){ //동적 이벤트
		                     
		                    var reply_id = $(this).attr("id");
		                    var last_check = false;
		                    
		                    $("#reply_add").remove();

		                    //입력받는 창 등록
		                     var replyEditor = 
		                    	 '<div id="reply_add" class="section1">'+
				         			'<div class="reviews">'+
				         				'<textarea class="form-control" style="resize: none;" id="reContent" name="reContent" placeholder="댓글을 입력하세요."></textarea>'+
				         				'<br>'+
				         				 '<button class="btn btn-outline-primary" name="reply_reply_save" reply_id="'+reply_id+'">등록</button>'+
					                        '&nbsp;&nbsp;'+
					                        '<button class="btn btn-outline-primary" name="reply_reply_cancel">취소</button>'+
				         			'</div>'+
				         		'</div>';

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
		                        prevTr.after(replyEditor);
		                  
		                });
						 
		              //대댓글 등록
		                $(document).on("click","button[name='reply_reply_save']",function(){
		                                         
		                    var reContent = $("textarea[name='reContent']");
		                    var eventId = $("input[name='eventId']");
		                    var content = reContent.val().replace("\n", "<br>"); //개행처리

		                    if(content.trim() == ""){
		                        alert("내용을 입력하세요.");
		                        content.focus();
		                        return false;
		                    }

		                    //값 셋팅
		                    var objParams = {	               
		                            eventId        : eventId.val(),
		                            parentId        : $(this).attr("reply_id"), 
		                            depth           : "1",
		                            content : content
		                    };
		                     
		                    var reply_id;
		                     
		                    //ajax 호출
		                    $.ajax({
		                    	url : "registEventComment.do",
								dataType : "json",
								type : "post",
								data : objParams,
		                        success     :   function(retVal){
		                        
		                        	location.hash
		                        	window.location.reload(true);
		                        	
		                        },
		                        error       :   function(request, status, error){
		                            console.log("AJAX_ERROR");
		                        }
		                    });
		                     
		             
		                     
		                });
		              

		              //댓글 삭제
		                $("button[name='reply_del']").click(function(){
		                     
		                    var check = false;
		                    var eventId = $("input[name='eventId']");
		                    
		                    //값 셋팅
		                    var objParams = {
		                            commentId : $(this).attr("id"),
		                            parentId : $(this).attr("parentId")
		                    };
		                     
		                    //ajax 호출
		                    $.ajax({
		                        url         :   "removeEventComment.do",
		                        dataType    :   "json",
		                        type        :   "get",
		                        data        :   objParams,
		                        success     :   function(retVal){
		                        	location.hash
		                        	window.location.reload(true);
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
		            	
		            	

		            	//수정
		            	  $(document).on("click","button[name='reply_update']",function(){ //동적 이벤트
			                     
			                    var reply_id = $(this).attr("id");
			                    var reply_content = $(this).attr("reply_comment");
			                    var last_check = false;
			                    
			                    $("#reply_add").remove();

			                    //입력받는 창 등록
			                     var replyEditor = 
			                    	 '<div id="reply_add" class="section2">'+
					         			'<div class="reviews">'+
					         				'<textarea class="form-control" style="resize: none;" id="modify" name="modify">'+reply_content+'</textarea>'+
					         				'<br>'+
					         				 '<button class="btn btn-outline-primary" name="reply_reply_update" reply_id="'+reply_id+'">수정</button>'+
						                        '&nbsp;&nbsp;'+
						                        '<button class="btn btn-outline-primary" name="reply_reply_cancel">취소</button>'+
					         			'</div>'+
					         		'</div>';

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
			                        prevTr.after(replyEditor);
			                  
			                });
		            	  
		            	  
		            	  //댓글 수정
			                $(document).on("click","button[name='reply_reply_update']",function(){
			                                         
			                    var eventId = $("input[name='eventId']");
			                    var content = $("textarea[name='modify']");
			           

			                    if(content.val().trim() == ""){
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
			                    $.ajax({
			                    	url : "modifyEventComment.do",
									dataType : "json",
									type : "Post",
									data : objParams,
			                        success     :   function(retVal){
			                        
			                        	location.hash
			                        	window.location.reload(true);
			                        	
			                        },
			                        error       :   function(request, status, error){
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

		
					<h2 align="right"><a href="eventList.do" class="btn btn-primary"  
						style="text-align: center;"> <strong style="color: white">이벤트 목록으로</strong></a></h2><br>
		

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

							<h3 align="left">장소 |${eventSpot.spotLocation }</h3>

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

					<c:forEach var="fullList" items="${fullJoinList }"
						varStatus="status">

						<div class="row">
							<div class="joinDate">
								<h3 style="font-size: 30px; margin-left: 10px;">
									[ ${fullList.key } ]
									<Button name="spreadBtn" class="btn_comm"
										onclick="showList(${status.count})">▼</Button>
								</h3>
							</div>

							<div class="1u" style="padding: 5px;">
								<div style="background-color: #FFF;">
									<a
										href="joinEvent.do?eventId=${eventDetail.eventId }&date=${fullList.key }"><strong><font
											color="#43C0CE">참여하기</font></strong></a>
								</div>
							</div>
						</div>

						<div id="dailyJoinList${status.count }" class="joinList"
							style="display: none">
							<div class="row" style="margin-top: 20px">
								<c:forEach var="guest" items="${fullList.value }"
									varStatus="rowCount">

									<div class="2u">
										<div
											style="width: 95%; background-color: #FFF; border-radius: 50px; -moz-border-radius: 50px; -khtml-border-radius: 50px; -webkit-border-radius: 50px;">
											<h2>${guest.userId }</h2>
											<img
												style="margin: 10px; width: 80%; border: 3px solid gold; border-radius: 120px; -moz-border-radius: 120px; -khtml-border-radius: 120px; -webkit-border-radius: 120px;"
												src="/images/${guest.petImage}">
											<h2>${guest.petInfo }</h2>
											<h2>${guest.contact }</h2>
										</div>
									</div>

									<c:if test="${rowCount.count%6 eq 0 }">
										</div> <div class="row" style="margin-top: 20px">
								    </c:if>
					</c:forEach>
				</div>
		</div>
		</c:forEach>

	</div>
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
			<ul reply_type="<c:if test="${comments.depth == '0'}">main</c:if><c:if test="${comments.depth == '1'}">sub</c:if>">
				<li>
		<c:if test="${comments.depth == '1'}"><div class="commenter"><ul><li></c:if>
					<div class="user-comment">
								<img src="/images/${user.petImage }" onclick="OnloadImg(this.src)">
								<header>
									<a class="name">${comments.writerId }</a>
									<span>${comments.registDate }</span>
									&nbsp;&nbsp;&nbsp;<c:if test="${comments.depth != '1'}"><button class="btn btn-outline-primary" name="reply_reply" id="${comments.commentId}">답글 달기</button></c:if>							
									 <c:if test="${loginUser.userId == comments.writerId}">
			    						<button class="btn btn-outline-primary" name="reply_update" reply_comment="${comments.content}" id="${comments.commentId}">수정</button>
										<button class="btn btn-primary" name="reply_del" parentId="${comments.parentId}" id="${comments.commentId}">삭제</button></c:if>
								</header>
								<div class="content">
									<p> ${fn:replace(comments.content, cn, br)}</p>
								</div>
					</div>
   		<c:if test="${comments.depth == '1'}"></li></ul></div></c:if>
				</li>
   			</ul>
		</c:forEach>
   		</div>
			<div class="section">
			<div class="reviews">
					<input type="hidden" id="eventId" name="eventId" value="${eventDetail.eventId }"> 
					<input type="hidden" id="parentId" name="parentId" value="0">
					<input type="hidden" id="depth" name="depth" value="0">
				<textarea class="form-control" rows="4" cols="40" style="resize: none;" id="content" name="content" placeholder="댓글을 입력하세요."></textarea>
				<br>
				<button id="reply_save" class="btn btn-primary" name="reply_save" >댓글 등록</button>
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
		function OnloadImg(url){
			  var img=new Image();
			  img.src=url;
			  var img_width=img.width;
			  var win_width=img.width+25;
			  var height=img.height+30;
			  var OpenWindow=window.open('','_blank', 'width='+img_width+', height='+height+', menubars=no, scrollbars=auto');
			  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+url+"' width='"+win_width+"'>");
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