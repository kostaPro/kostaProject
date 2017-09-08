<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>인사관리 시스템</title>
    <link rel="stylesheet" href="style/css/reset.css">
    <link rel="stylesheet" href="style/css/style.css">
</head>
<body>
<header>
    <h1>
        <a href="deptList.do">인사관리 시스템</a>
    </h1>
    <ul class="login-info">
        <li class="logout-btn"><a href="logout.do">로그아웃</a></li>
    </ul>
</header>
<nav>
    <ul>
        <li class="user-info">
            ${userName } 님
        </li>
        <li>
            <a href="deptList.do">부서목록</a>
        </li>
        <li>
            <a href="deptCreate.do">부서등록</a>
        </li>
        <li>
            <a href="employeeList.do">전체직원목록</a>
        </li>
        <li>
            <a href="employeeCreate.do">직원등록</a>
        </li>
        <li>
            <a href="#">시스템관리</a>
        </li>
    </ul>
</nav>
<div class="contents-wrap">
    <h2 class="page-title"> 인사관리 시스템 MENU </h2>

</div>
<footer>
    <p>    &#169; 2016. Nextree all rights reserved.</p>
</footer>
</body>
</html>














