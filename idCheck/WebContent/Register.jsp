<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#id").keyup(function(){
			if($("#id").val().length > 5){
				var id = $(this).val();
				
				$.ajax({
					type:'POST',
					url: 'checkId.do',
					data:
						{
							id : id
						},
					success: function(result){
						if($.trim(result) == 'ok'){
							$("#idCheckResult").html("available ID");							
					 	}else{
							$("#idCheckResult").html("disavailable ID");
						}
					}
				});
			}else{
				$("#idCheckResult").html("ID required over 5 charecter");
			}
		});
	});
</script>
</head>
<body>

	<input type="text" id="id" name="idCheck" placeholder="insert ID">
	<span id="idCheckResult"></span>
</body>
</html>