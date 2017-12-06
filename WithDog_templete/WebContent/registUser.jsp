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


		<style type="text/css">
select {
	style="background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 15px 32px;
  text-align-last: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width: 85%;
  border: 2px solid #f6f6f6;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;"
	
}

}
</style>

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
      <input type="password" id="confirm" class="fadeIn third" placeholder="confirm password">
      <input type="text" id="contact" class="fadeIn second" name="contact" placeholder="contact">

                  <select name="favoriteLocation" >
                     <option value="">&nbsp&nbsp&nbsplocation</option>
                     <option value="서울">서울</option>
                     <option value="경기">경기</option>
                     <option value="인천">인천</option>
                     <option value="강원">강원</option>
                     <option value="부산">부산</option>
                     <option value="경남">경남</option>
                     <option value="전남">전남</option>
                     <option value="전북">전북</option>
                     <option value="경북">경북</option>
                     <option value="충남">충남</option>
                     <option value="충북">충북</option>
                     <option value="제주특별자치도">제주</option>
                  </select>
      <input type="text" id="petInfo" class="fadeIn second" name="petInfo" placeholder="ex) Poodle/3Y/Male dog">



      <section>
                           <label class="upload-button">애견 이미지 첨부<input
                              style="display: none" type="file" name="pImage" id="pImage"
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