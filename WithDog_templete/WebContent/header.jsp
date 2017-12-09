<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<div class="container">

			<!-- Logo -->
			<div id="logo">
					<div style="width: 100%; height: 100px; line-height: 100px; text-align: center">
					<a href="main.jsp"><img src="resources/img/main_logo.png" style="width: 270px; height: auto; vertical-align:center;"
					alt=""></a></div>
				
			</div>
		</div>
		<div id="nav-wrapper" class="container">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li class="active"><a href="main.do">Home</a></li>
					<li><a href="meetingList.do">모임</a></li>
					<li><a href="spotList.do">장소</a></li>
					<li><a href="eventList.do">이벤트</a></li>
					
					<c:choose>
					<c:when test="${loginUser.userId ne 'admin'}">
					<li><a href="myPage.do">MyPage</a></li>
					</c:when>
					<c:otherwise>
					<li><a href="adminPage_searchByReportType.do">MyPage</a></li>
					</c:otherwise>
					</c:choose>
					
					<li><a href="myPage.do">${loginUser.userId } 회원님 반갑습니다.</a></li>
					<li><a href="logout.do">로그아웃</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
			<div id="banner">
				<a href="#" class="image featured"><img src="resources/img/pics13.jpg"
					alt=""></a>
			</div>
		</div>
	</div>
</body>
</html>