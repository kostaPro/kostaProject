<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<h1>
					<a href="#">WithDog</a>
				</h1>
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
					<li><a href="myPage.do">MyPage</a></li>
					<li><a href="myPage.do">${loginUser.userId } 회원님 반갑습니다.</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
			<div id="banner">
				<a href="#" class="image featured"><img src="resources/img/pics11.jpg"
					alt=""></a>
			</div>
		</div>
	</div>
</body>
</html>