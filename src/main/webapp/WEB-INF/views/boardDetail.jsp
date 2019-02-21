<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>회원가입</title>

<style>
	#container{
		margin : 0 auto;
	}
</style>
<script>
	$(document).ready(function() {
			$("#update").click(function(){ 
				$('#form').attr('action', "update");
				$("#form").submit();
			});
			$("#delete").click(function(){
				$('#form').attr('action', "delete");
				$("#form").submit();
			});
		});
</script>

</head>
<body>
	<div id="container"></div>
	<h1>상세보기</h1>
	<hr>
	<form id="form" method="post">
		<table class="table table-striped">
			<input type = "hidden" name = "seq" value = "${board.seq }">
			<tr>
				<td>제목</td>
				<td><input type = "text" name = "title" class = "form-control" value = "${board.title }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type = "text" name = "writer" class = "form-control" value = "${board.writer }"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "password" class = "form-control" ></td>
			</tr>
			<tr>
				<td colspan = "2"><textarea rows="5" cols="40" name = "content" class = "form-control">${board.content }</textarea></td>
			</tr>
			<tr>
			<td><input type = "button" id = "update" value = "수정하기"class = "btn btn-primary"></td>
			<td><input type = "button" id = "delete" value = "삭제하기"class= "btn btn-primary"></td>
			</tr>
			<tr>
			<td>
			<td><input type = "button" id = "reply" value = "답글쓰기" class = "btn btn-primary"
			onclick="location='reply?groups=${board.groups }&levels=${board.levels }&steps=${board.steps }'"></td>
				<td><a href = "getList" class = "btn btn-primary">목록으로</a></td> 
			</tr>
		</table>
	</form>

</body>
</html>