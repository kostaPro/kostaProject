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
      <script type="text/javascript" src="resources/js/image.js"></script>


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

</style>

<script type="text/javascript">

var Check1 = 0;
var Check2 = 0;
//아이디 체크하여 가입버튼 비활성화, 중복확인.
 $(document).ready(function(){
      $("#inputId").keyup(function () {
    var inputId = $('#inputId').val();
    $.ajax({
    	type : 'POST',
        data : {
            userId : inputId
        },
        url : 'checkId.do',
        dataType : 'text',
        success : function(data) {
            if(data=="success" && inputId != "") {
            	Check1 = 1;
                $("#idCheck").html("사용 가능한 ID입니다.")
                if(Check1 == 1 && Check2 == 1){
                $(".fadeIn_fourth").prop("disabled", false);
                $(".fadeIn_fourth").css("background-color", "#5DB9E2");
                }
            }else{
            	Check1 = 0;
            	 $("#idCheck").html("사용 불가능한 ID입니다.");
            	 $(".fadeIn_fourth").prop("disabled", true);
            	 $(".fadeIn_fourth").css("background-color", "#8C8C8C");
            	
            }
       	 }
    	});
	});
      $("#confirm").keyup(function () {
    	   var inputed = $('#password').val();
    	   var reInputed = $('#confirm').val();
    	   if(inputed == reInputed){
    		   Check2 = 1;
    		   $("#pwCheck").html("비밀번호가 일치합니다.")
    		    if(Check1 == 1 && Check2 == 1){
    	       $(".fadeIn_fourth").prop("disabled", false);
    	       $(".fadeIn_fourth").css("background-color", "#5DB9E2");
    		    }
    	   }else{
    		   Check2 = 0;
    		   $("#pwCheck").html("비밀번호가 불일치합니다.");
    	  	   $(".fadeIn_fourth").prop("disabled", true);
    	  	   $(".fadeIn_fourth").css("background-color", "#8C8C8C");
    	   }
    		});
      
});



     


</script>


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
      <input type="text" id="inputId" class="fadeIn second" name="userId" placeholder="ID" required="required" maxlength="10">
      <p id="idCheck"></p>
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="password" required="required" required class="pass">
      <input type="password" id="confirm" class="fadeIn third" placeholder="confirm password" required="required" required class="pass">
      <p id="pwCheck"></p>
      <input type="text" id="contact" class="fadeIn second" name="contact" placeholder="contact" required="required">

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
      <input type="text" id="petInfo" class="fadeIn second" name="petInfo" placeholder="ex) Poodle/3Y/Male dog" maxlength="15">



      <section>
                           <label class="upload-button">애견 이미지 첨부<input
                              style="display: none" type="file" name="pImage" id="pImage"
                              multiple="multiple"/>
                           </label>
                           <img src="#" id="pet_image" style="width:300px; display: absolute; float:center">
                        </section>









      <input type="submit" class="fadeIn_fourth" value="Regist" disabled="disabled">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#"></a>
    </div>

  </div>
</div>


</body>
</html>
