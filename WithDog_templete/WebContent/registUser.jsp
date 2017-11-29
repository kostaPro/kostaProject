<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>With Dog</title>
  
 
  
  	  <script type="text/javascript" src="resources/js/jquery-3.1.0.min.js"></script>
	  <script type="text/javascript" src="resources/js/userImage.js"></script>
  
      <link rel="stylesheet" href="resources/css/loginStyle.css">

  
</head>

<body>
  <div class="wrapper fadeInDown">
  <div id="formContent">
    
     <!-- Icon -->
    <div class="fadeIn first">
      <img src="resources/img/logo.jpg" id="icon" alt="User Icon" />
    </div>
    
    
    <!-- Login Form -->
    <form action="registUser.do" method="POST" enctype="multipart/form-data">
      <input type="text" id="userId" class="fadeIn second" name="userId" placeholder="ID">
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="text" id="contact" class="fadeIn second" name="contact" placeholder="contact">
      
						<select form="location" name="favoriteLocation" >
							<option value="선호지역">&nbsp&nbsp&nbsplocation</option>
							<option value="서울특별시">서울</option>
							<option value="경기도">경기</option>
							<option value="인천광역시">인천</option>
							<option value="강원도">강원</option>
							<option value="부산광역시">부산</option>
							<option value="경상남도">경남</option>
							<option value="전라남도">전남</option>
							<option value="전라북도">전북</option>
							<option value="경상북도">경북</option>
							<option value="충청남도">충남</option>
							<option value="충청북도">충북</option>
							<option value="제주특별시">제주</option>
						</select>
		<input type="text" id="petInfo" class="fadeIn second" name="petInfo" placeholder="ex) Poodle/3Y/Male dog">				
		
		
		
		<section>
									<label class="upload-button">애견 이미지 첨부<input
										style="display: none" type="file" name="petImage" id="petImage"
										multiple="multiple" />
									</label>
									<img src="#" id="pet_image" style="width:300px; display: absolute; float:center">
								</section>
						

				
			


		
		
											
      <input type="submit" class="fadeIn fourth" value="Regist">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#"></a>
    </div>

  </div>
</div>
  
  
</body>
</html>
