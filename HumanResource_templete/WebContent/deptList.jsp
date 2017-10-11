<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>부서목록</title>
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
        <li class="on">
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
    <h2 class="page-title">부서목록</h2>
    <div class="contents">
        <table border="1">
            <colgroup>
                <col width="90">
                <col width="150">
                <col width="*">
                <col width="90">
            </colgroup>
            <thead>
            <tr>
                <th>번호</th>
                <th>부서코드</th>
                <th>부서명</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${deptList }" var="dept" varStatus="status">
            <tr>
                <td>${status.count }</td>
                <td>${dept.no }</td>
                <td><a href="deptDetail.do?deptNo=${dept.no }">${dept.name }</a></td>
                <td class="delete"><a href="deleteDept.do?deptNo=${dept.no }">삭제</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<footer>
    <p>    &#169; 2016. Nextree all rights reserved.</p>
</footer>
</body>
</html>








