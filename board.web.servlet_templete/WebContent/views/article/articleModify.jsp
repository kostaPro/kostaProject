<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
 * COPYRIGHT (c) Nextree Consulting 2015
 * This software is the proprietary of Nextree Consulting.  
 * 
 * @author <a href="mailto:eschoi@nextree.co.kr">Choi, Eunsun</a>
 * @since 2015. 1. 9.
-->
<!DOCTYPE html>
<html lang="ko">
<head>

<title>소셜보드</title>
<meta charset="utf-8">
<%@include file="/views/layout/common.jsp"%>

</head>
<body>

	<!-- Main Navigation ========================================================================================== -->
	<%@ include file="/views/layout/menu.jsp"%>
	<!-- Header ========================================================================================== -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="jumbotron">
						<h2>게시판</h2>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<ol class="breadcrumb">
						<li><a href="#">홈</a></li>
						<li><a href="#">게시판</a></li>
						<li class="active">${boardDetail.name }</li>
					</ol>
				</div>
			</div>
		</div>
	</header>

	<!-- Container ======================================================================================= -->

	<div class="container">
		<div class="row">

			<div style="z-index: 1020"
				class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
				<div class="list-group panel panel-success">
					<div class="panel-heading list-group-item text-center hidden-xs">
						<h4>게시판</h4>
					</div>
					<div>
						<c:forEach var="board" items="${boards }">
							<a href="${ctx}/board/find.do?boardId=${board.boardId}"
								class="list-group-item hidden-xs">${board.name } </a>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="col-sm-9 col-lg-9">
				<div>
					<h3>게시판 이름</h3>
				</div>

				<form action="${ctx }/article/modify.do" method="POST">
					<div class="panel panel-default">
						<div class="panel-heading">${articleDetail.title }</div>
						<div class="panel-body">
							<div class="post">
								<div class="write_info">
									<span class="name">${articleDetail.authorName }</span> <span class="date"><span
										class="_val">${articleDetail.regDate }</span></span>

								</div>

							</div>
							<div class="form-group">
										<input type="hidden" name="articleId"
											value="${articleDetail.articleId }"> 
								<textarea class="form-control" name="contents" rows="5">${articleDetail.contents}</textarea>
							</div>
						</div>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">저장</button>
						<a href="${ctx }/article/find.do?articleId=${articleDetail.articleId }" class="btn btn-default">취소</a>
					</div>
				</form>
			</div>
		</div>

		<!-- Footer ========================================================================================== -->
		<%@ include file="/views/layout/footer.jsp"%>
	</div>

</body>
</html>