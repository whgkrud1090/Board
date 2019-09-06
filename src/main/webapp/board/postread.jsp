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
				<input type="hidden" name="boardNm" id="boardNm" value="${param.boardNm }"/>
				<h2 class="sub-header">${param.boardNm}</h2>
				<input type="hidden" name="postId" id="postId" value="${param.postId }"/>
					<br>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${post.postNm }</label>
							<input type="hidden" id="postNm" name="postNm" value="${post.postNm }"/>
						</div>
					</div>

					<br>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<p>${post.postCont }</p>
							<input type="hidden" id="postCont" name="postCont" value="${post.postCont }"/>
						</div>
					</div>
					<br>
						<div class="form-group">
						<c:if test="${countfile > 0 }">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-7">
							<c:forEach items="${file }" begin="1" end="${countfile }" var="file">
							${file.upFilenm }<br>
							</c:forEach>
						</div>
						</c:if>
					</div>
					<br>
						<div class="form-group">
						<div class="col-sm-1">
							<input type="button" class="btn btn-default btn btn-warning"  name="modiyBtn" value="수정"/>
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-default btn btn-danger"  name="deleteBtn">삭제</button>
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-default btn-success" name="answerBtn">답글</button>
						</div>
						</div>
					
					<div class="form-group">
						<div class="col-sm-10">
						<br>
						<br>
						<label for="pass" class="col-sm-2 control-label">댓글</label>
						<%-- 댓글처리 --%>
<%-- 							<div>${post.postCont }</div> --%>
<%-- 							<div>${post.userId } / ${post.postUp }</div> --%>
							<input type="hidden" id="userId" name="userId" value="${post.postCont }"/>
						</div>
					</div>
					<br>
					
					<div class="form-group">
						<div class="col-sm-10">
						<br>
							<textarea rows="3" cols="80" name="comment" id="comment"></textarea>
						<button type="button" class="btn btn-default btn btn-info commentSave">댓글저장</button>					
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
