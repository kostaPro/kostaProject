<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result</title>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$.ajax({
			url : "ajax.do",
			type : "Post",
			dataType : "json",
			success : function(responseData) {
				var data = responseData.person;
				alert(data.contact);
				console.log(data.contact);
				var html = "";

				html += "<h1>과정명 : " + data.contact + "</h1>";
				$("div").append(html);
			}
		});

	});
</script>
</head>
<body>
<div></div>
</body>
</html>