@@ -0,0 +1,47 @@
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>회원가입</title>

<style>
	#container{
		margin : 0 auto;
	}
</style>

</head>
<body>
	<div id="container"></div>
	<h1>회원가입</h1>
	<hr>
	<form name="form" action="insert" method="post">
		<table class="table table-striped">
			<tr>
				<td>제목</td>
				<td><input type = "text" name = "title" class = "form-control"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type = "text" name = "writer" class = "form-control"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "password" class = "form-control"></td>
			</tr>
			<tr>
				<td colspan = "2"><textarea rows="5" cols="40" name = "content" class = "form-control"></textarea></td>
			</tr>
			<tr>
			<td><input type = "submit" value = "글쓰기"></td>
			<td><input type = "reset" value = "다시쓰기"></td>
			</tr>
		</table>
	</form>
	

</body>
</html>