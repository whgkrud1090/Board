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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="favicon.ico" />
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<%@ include file="/commonJsp/basicLib.jsp"%>
<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
	})
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

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
	<form class="form-horizontal" action="${cp }/newPostPage" method="post" id="frm">
			<h2 class="sub-header">${param.boardNm}</h2>
		<div class="form-group">
		<div class="col-sm-10">
				<label class="control-label">제목</label>
				<input type="hidden" name="boardNm" id="boardNm" value="${param.boardNm }"/>
				<input type="hidden" id="userId" name="userId" value="${param.userId }"/>
				<input type="hidden" id="boardId" name="boardId" value="${param.boardId }"/>
				<input type="text" class="form-control" id="newPostNm" name="newPostNm" value="${param.newPostNm } "/>
				</div>
		</div>
		<div class="form-group">
				<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
		</div>
		
<!-- 		<div class="col-sm-10"> -->
<!-- 				<label for="newpostNm" class="control-label">첨부파일</label> -->
<!-- 				<input type="file" class="form-control" id="attaFile" name="attaFile" placeholder="첨부파일"/> -->
<!-- 				</div> -->
<!-- 		</div> -->

		<div class="form-group">
				<input type="submit" id="savebutton" class="btn btn-default" value="저장" />
		</div>
	</form>
	</div>
</div>
</div>
	</div>
</div>
</body>
</html>
