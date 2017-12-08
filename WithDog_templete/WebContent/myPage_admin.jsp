<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Elemental by TEMPLATED
    templated.co @templatedco
    Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>Insert title here</title>
	</head>
	<body>


	<!-- Main -->

					<div id="sidebar" class="3u">
						<section>
							<header>
								<h2>MyPage</h2>
							</header>
							<p></p>
							<ul class="style1">
								<div class='toggle_parent'>
  <div class='toggleHolder'>
    <span class='toggler'><font color="#000000">신고 관리</font></span>
    <span class='toggler' style='display:none;'><font color="#000000">신고 관리</font></span>
  </div>
  <div class='toggled_content' style='display:none;'><a href="adminPage_searchByReportType.do">신고 구분별 조회</a></div>
  <div class='toggled_content' style='display:none;'><a href="adminPage_blackList.do">블랙 리스트 조회</a></div>
</div>
								
								
								<li><a href="adminPage_spot.do">장소 관리</a></li>
								<li><a href="adminPage_event.do">이벤트 관리</a></li>
							</ul>
						</section>
						
					</div>
					
					
	
	</body>
	<script>
		
		$('.toggler').live('click',function(){
			  $(this).parent().children().toggle();  //swaps the display:none between the two spans
			  $(this).parent().parent().find('.toggled_content').slideToggle();  //swap the display of the main content with slide action

			});
		
	</script>
</html>