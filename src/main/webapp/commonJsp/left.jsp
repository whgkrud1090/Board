<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav nav-sidebar">
	<li class="active"><a href="${cp }/boardadminPage">게시판생성<span class="sr-only">(current)</span></a></li>
<c:forEach items="${boardList }" var="board">
	<c:if test="${board.useCk == 0 }">
	<li class="active">
	<a href="${cp }/postPage?boardNm=${board.boardNm}&boardId=${board.boardId}&userId=${param.userId}">${board.boardNm }<span class="sr-only">(current)</span>
	</a></li>
	</c:if>
</c:forEach>
</ul>
