<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>로그인</title>
    <link rel="stylesheet" href="style/css/reset.css">
    <link rel="stylesheet" href="style/css/style.css">
</head>
<body>
<div class="login-wrap">
    <h3>로그인</h3>
    <form action="login.do" method="post">
        <label>아이디</label>
        <input type="text" name="loginId" placeholder="아이디를 입력하세요.">
        <label>비밀번호</label>
        <input type="password" name="passwd" placeholder="패스워드를 입력하세요.">
        <div class="login-btn">
            <input type="reset" value="취소">
            <input type="submit" value="로그인">
        </div>
    </form>
</div>
</body>
</html>



