<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>부서배정</title>
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
            이순신 님
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
    <h2 class="page-title">부서배정</h2>
    <div class="contents">
        <form action="assignDept.do" method="post">
            <table>
                <tr>
                    <td><input type="hidden" value="${employee.no }" name="empNo"/>사번 : ${employee.no }</td>
                </tr>
                <tr>
                    <td>이름 : ${employee.name }</td>
                </tr>
                <tr>
                    <td>
                        <select name="deptNo">
                            <option>== 부서선택 ==</option>
                            <c:forEach items="${deptList }" var="dept">
                       		     <option value="${dept.no }">${dept.name }</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <br>
            <div class="alignRight">
                <input type="submit" value="배정">
            </div>
        </form>
    </div>
</div>
<footer>
    <p>    &#169; 2016. Nextree all rights reserved.</p>
</footer>
</body>
</html>






