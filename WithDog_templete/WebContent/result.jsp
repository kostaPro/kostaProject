<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Light UI Kit</title>


<link rel="stylesheet" href="resources/css/commentStyle.css">
<script src="https://code.jquery.com/jquery-2.2.3.js"></script>

</head>

<body>

			<div id="post" class="con">
				<header>
					<img
						src="https://cdn1.iconfinder.com/data/icons/flat-business-icons/128/user-64.png"
						alt="">
					<p>
						<a href="#" class="name">Daniel Svensson</a> uploaded a new photo
						to the album <a href="#">Beautiful Nature</a>.<span>20.04.2015
							@ 12:00 PM</span>
					</p>
					<div class="option"></div>
				</header>

				<div class="content">
					<p>Nautre’s beauty can’t be described in words.</p>
					<img
						src="https://placeholdit.imgix.net/~text?txtsize=56&txt=600%C3%97300&w=600&h=300"
						alt="">
					<div id="social">
						<div class="post-comments">402</div>
						<div class="likes">2k</div>
					</div>
				</div>

				<div class="hide-comments">
					<input type="checkbox" value="" id="hide-button" name="check"
						checked /> <label for="hide-button" class="button">Hide
						Comments</label>
				</div>

				<div class="comments">
					<ul>
						<li>
							<div class="user-comment">
								<img
									src="https://cdn1.iconfinder.com/data/icons/flat-business-icons/128/user-32.png"
									alt="">
								<header>
									<a href="#" class="name">Josephine Bowler</a><span>20.02.2015
										@ 09:01</span>
								</header>
								<div class="content">
									<p>This picture is absolutely amazing! You are such a good
										photographer :)</p>
								</div>
								<a href="" class="reply">Reply</a>
							</div>
						</li>

						<li>
							<div class="user-comment">
								<img
									src="https://cdn1.iconfinder.com/data/icons/flat-business-icons/128/user-32.png"
									alt="">
								<header>
									<a href="#" class="name">Damian Markovic</a><span>20.02.2015
										@ 12:46</span>
								</header>
								<div class="content">
									<p>Dude, this has got to be one of the most outstanding
										photo I’ve ever seen! Love this album and love your work! Keep
										up the good work!</p>
								</div>
								<a href="" class="reply">Reply</a>
							</div>
							<ul>
								<li>
									<div class="user-comment">
										<img
											src="https://cdn1.iconfinder.com/data/icons/flat-business-icons/128/user-32.png"
											alt="">
										<header>
											<a href="#" class="name">Daniel Svensson</a><span>20.02.2015
												@ 13:46</span>
										</header>
										<div class="content">
											<p>Thank you so much for your compliments! I try my best
												:)</p>
										</div>
										<a href="" class="reply">Reply</a>
									</div>
								</li>
							</ul>
						</li>

						<li>
							<div class="user-comment">
								<img
									src="https://cdn1.iconfinder.com/data/icons/flat-business-icons/128/user-32.png"
									alt="">
								<header>
									<a href="#" class="name">Jennifer Lee</a><span>21.02.2015
										@ 14:00</span>
								</header>
								<div class="content">
									<p>Wow!!! Cool shot, Daniel! You should post more often =)</p>
								</div>
								<a href="" class="reply">Reply</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
	<script>
		//        $(function () {
		$("#hide-button").click(function() {
			if ($(this).is(":checked")) {
				$("label").text("Hide Comments");
				$(".comments").slideDown(300);
			} else {
				$("label").text("Show Comments");
				$(".comments").slideUp(300);
			}
		});
		//        });
	</script>
</body>
</html>

