<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.js"></script>

<script type="text/javascript" >

	$(document).ready(function(){
		var group2 = ${group2};
		var group1 = ${group1};
		
		for(var i = 0 ; i < group1.length ; i++){
			$("#group_1").append("<option value = ' "+ group1[i] +"'>" + group1[i] + "</option>");
		}
		
		for(var i = 0 ; i < group2.length ; i++){
			$("#group_2").append("<option value = ' "+ group2[i] +"'>" + group2[i] + "</option>");
		}
	});
</script>
</head>
<body>

	<select id="group_1">
		<option value="empty">선택없음</option>
	</select>
	
	<select id="group_2">
		<option value="empty">선택없음</option>
	</select>
	
</body>
</html>