<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Elemental by TEMPLATED
    templated.co @templatedco
    Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>Welcome To WithDog</title>

<!--화면 전체 디자인-->
<link rel="stylesheet" href="resources/css/skel-noscript.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />

<!--이미지 슬라이드-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


<script>
	$(document).ready(function() {
		$('#eventSlider').bxSlider({
			auto : true,
			pager : false,
			slideWidth : 200,
			minSlides : 2,
			maxSlides : 3,
			slideMargin : 10,
			moveSlides : 2,
			nextSelector : '#eventSlider_next',
			prevSelector : '#eventSlider_prev',
			nextText : 'next',
			prevText : 'prev'

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
			<section>
				<header>
					<h2>Event List</h2>
				</header>

				<div class="slideWrap">
					<div id="eventSlider" class="slider">
						<c:forEach var="event" items="${eventList }">
							<div class="slide">
								<img src="/images/${event.eventImage}">
								<p>${event.eventName }</p>
							</div>
						</c:forEach>
					</div>
					<span id="eventSlider_prev" class="slider_prev css3button"></span>
					<span id="eventSlider_next" class="slider_next css3button"></span>
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
							<h2>Praesent mattis</h2>
						</header>
						<ul class="default">
							<li><img src="resources/img/pics04.jpg" width="78"
								height="78" alt="">
								<p>Nullam non wisi a sem eleifend. Donec mattis libero.</p> <span
								class="posted">May 9th | (10 ) Comments</span></li>
							<li><img src="resources/img/pics05.jpg" width="78"
								height="78" alt="">
								<p>Nullam non wisi a sem eleifend. Donec mattis libero.</p> <span
								class="posted">May 1st | (10 ) Comments</span></li>
							<li><img src="resources/img/pics06.jpg" width="78"
								height="78" alt="">
								<p>Nullam non wisi a sem eleifend. Donec mattis libero.</p> <span
								class="posted">April 28th | (10 ) Comments</span></li>
						</ul>
					</section>
				</div>
				<div class="3u">
					<section>
						<header>
							<h2>Maecenas luctus</h2>
						</header>
						<ul class="default">
							<li><img src="resources/img/pics07.jpg" width="78"
								height="78" alt="">
								<p>Nullam non wisi a sem eleifend. Donec mattis libero.</p> <span
								class="posted">May 9th | (10 ) Comments</span></li>
							<li><img src="resources/img/pics08.jpg" width="78"
								height="78" alt="">
								<p>Nullam non wisi a sem eleifend. Donec mattis libero.</p> <span
								class="posted">May 1st | (10 ) Comments</span></li>
							<li><img src="resources/img/pics09.jpg" width="78"
								height="78" alt="">
								<p>Nullam non wisi a sem eleifend. Donec mattis libero.</p> <span
								class="posted">April 28th | (10 ) Comments</span></li>
						</ul>
					</section>
				</div>
				<div class="6u">
					<section>
						<header>
							<h2>Elementum facilisis</h2>
						</header>
						<a href="#" class="image full"><img
							src="resources/img/pics10.jpg" alt=""></a>
						<p>
							This is <strong>Elemental</strong>, a responsive HTML5 site
							template freebie by <a href="http://templated.co">TEMPLATED</a>.
							Released for free under the <a href="http://templated.co/license">Creative
								Commons Attribution</a> license, so use it for whatever (personal or
							commercial) &ndash; just give us credit! Check out more of our
							stuff at <a href="http://templated.co">our site</a> or follow us
							on <a href="http://twitter.com/templatedco">Twitter</a>.
						</p>
						<p>Consectetuer adipiscing elit. Nam pede erat, porta eu,
							lobortis eget, tempus et, tellus. Etiam neque. Vivamus consequat
							lorem at nisl. Nullam non wisi a sem semper eleifend. Donec
							mattis libero eget urna. Duis pretium velit ac mauris.</p>
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

</body>
</html>