<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>부서 상세정보</title>
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
    <h2 class="page-title">부서 상세조회</h2>
    <div class="contents">
        <div class="info-box">
            부서번호 : ${deptNo } <br>
            부서명 : ${deptName }
        </div>
        <table>
            <colgroup>
                <col width="90">
                <col width="*">
                <col width="*">
            </colgroup>
            <thead>
            <tr>
                <th>번호</th>
                <th>사번</th>
                <th>이름</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${empList }" var="emp" varStatus="status">
            <tr>
                <td>${status.count }</td>
                <td>${emp.no }</td>
                <td>${emp.name }</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="employeeCreate.do?deptNo=${deptNo }"><button>신규직원등록</button></a>
    </div>
</div>
<footer>
    <p>    &#169; 2016. Nextree all rights reserved.</p>
</footer>
</body>
</html>