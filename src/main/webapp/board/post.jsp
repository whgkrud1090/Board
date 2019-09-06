<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>
<%@ include file="/commonJsp/basicLib.jsp"%>
<script>
$(document).ready(function(){
});
</script>
</head>

<body>
<!-- header -->
<%@ include file="/commonJsp/header.jsp" %>
	
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<!-- left -->

			<%@ include file="/commonJsp/left.jsp" %>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<div class="row">
				<div class="col-sm-8 blog-main">
<%-- 				<input type="hidden" name="boardId" id="boardId" value="${param.boardId }"/> --%>
<%-- 				<input type="text" id="userId" name="userId" value="${board.userId }"/> --%>
<%-- 				<input type="text" id="userId" name="userId" value="${board.boardNm }"/> --%>
					<h2 class="sub-header">${param.boardNm}</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일시</th>
							</tr>
							<c:forEach items="${postList }" var="post">
							<tr>
								<td>${post.postId }</td>
								<td>${post.postNm }</td>
								<td>${post.userId }</td>
								<td>${post.postUp }</td>
							</tr>
							</c:forEach>
						</table>
					</div>
						<a class="btn btn-default pull-right" href="${cp }/newPostPage">새글 등록</a>
						<nav aria-label="Page navigation example">
						  <ul class="pagination pagination-circle pg-blue">
						    <li class="page-item disabled">
						      <a class="page-link" aria-label="Previous">
						        <span aria-hidden="true">&laquo;&laquo;</span>
						        <span class="sr-only">First</span>
						      </a>
						    </li>
						    <li class="page-item disabled">
						      <a class="page-link" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						        <span class="sr-only">Previous</span>
						      </a>
						    </li>
							<li class="active"><a class="page-link">${post.page }</a></li>
						    <li class="page-item">
						      <a class="page-link" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						        <span class="sr-only">Next</span>
						      </a>
						    </li>
						    <li class="page-item">
						      <a class="page-link" aria-label="Next">
						        <span aria-hidden="true">&raquo;&raquo;</span>
						        <span class="sr-only">Last</span>
						      </a>
						    </li>
						  </ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
