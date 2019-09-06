<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<title>BOARDADMIN</title>
<%@ include file="/commonJsp/basicLib.jsp"%>
<style type="text/css">
select {
    width: 100px; /* 원하는 너비설정 */
    padding: .8em .8em; /* 여백으로 높이 설정 */
    border: 1px solid #999;
    border-radius: 10px; /* iOS 둥근모서리 제거 */
    appearance: none;
}

</style>
<script>
	$(document).ready(function() {
		
		$('.modifBtn').on('click', function() {
			var str = ""
			var checkBtn = $(this);
			
			var tr = checkBtn.parent().parent();
			var td = tr.children().val();

			console.log("trChilder : "+td);
			
			var idValue = $(tr).data("boardid");
			
			console.log("idValue : " + idValue);
			
			$("#boardId").val(idValue);
				
			console.log("serialize : "  + $("#frm").serialize());
			$("#frm").submit();
		})
	});
</script>
</head>

<body>


	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/commonJsp/left.jsp"%>
			</div>
			<div class="col-sm-5 col-sm-offset-2 col-md-7 col-md-offset-3 main">
				<form class="form-horizontal" role="form" action="${cp }/boardadminPage" method="post">
				<table class="table table-striped">
				<c:forEach items="${boardList }" var="board" begin="0" end="0">
					<input type="hidden" value="${board.userId }" name="userId" />
				</c:forEach>
					<tr>
						<td>
						<label>게시판이름</label>
						</td>
						<td>
						<input type="text" class="form-control" id="newBoardNm" name="newBoardNm">
						</td>
						<td>
						<select id="newUseCk" name="newUseCk">
							<option value="0">사용</option>
							<option value="1">미사용</option>
						</select>
						</td>
						<td>
							<button type="submit" class="btn btn-default btn btn-primary" id="createBoard" value="1" name="param">생성</button>
						</td> 
					</tr>
					</table>
				</form>
				
				
			<form id="frm" action="${cp }/boardadminPage" method="post">
			<input type="hidden" id="boardId" name="boardId"/>
			<input type="hidden" id="param" name="param" value="0"/>
			<table class="table table-striped">
				<c:forEach items="${boardList }" var="board" begin="0">
				<tr class="boardTr" data-boardId="${board.boardId }" data-useCk="${board.useCk }">
				<input type="hidden" value="${board.boardId }" name="boardId"/>
					<td>게시판이름</td>
					
					<td> 
					<input type="text" class="form-control" name="boardNm" value="${board.boardNm}" disabled="disabled"/>
					</td>
					
					<td>
					<select name="useCk" id="useCk">
						<c:if test="${board.useCk == '0' }">
								<option value="0" selected="selected">사용</option>
								<option value="1">미사용</option>
						</c:if>
						<c:if test="${board.useCk == '1' }">
								<option value="0">사용</option>
								<option value="1" selected="selected">미사용</option>
						</c:if>
					</select>
					</td>

					<td>
						<button type="button" class="btn btn-default btn btn-warning modifBtn">수정</button>					
					</td> 
				</tr>
				</c:forEach>
			</table>
			</form>
		</div>
	</div>
</div>
</body>
</html>
