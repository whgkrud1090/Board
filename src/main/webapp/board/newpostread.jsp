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
					<br>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${param.postNm }</label>
							<input type="hidden" id="postNm" name="postNm" value="${param.postNm }"/>
						</div>
					</div>

					<br>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<p>${param.postCont }</p>
							<input type="hidden" id="postCont" name="postCont" value="${param.postCont }"/>
						</div>
					</div>
						<div class="form-group">
						<div class="col-sm-1">
							<input type="button" class="btn btn-default btn btn-warning"  name="modiyBtn" value="수정"/>
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-default btn btn-danger"  name="deleteBtn">삭제</button>
						</div>
						</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
