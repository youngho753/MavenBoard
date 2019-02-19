<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script>
	
</script>
</head>
<body>
	<div align="center">
	<h1>게시판 목록보기</h1>
	<h3><a href="insert">회원가입</a></h3>
		<table class="table table-striped">
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${boardList}" var="boardList" varStatus="status">
			<tr>
				<td>${boardList.seq}</td>
				<td><a href="detail?seq=${boardList.seq}">${boardList.writer}</a></td>
				<td>${boardList.title}</td>
				<td>${boardList.content}</td>
				<td><a href="delete.my?id=${boardList.seq}">삭제</a></td>
			</tr>
			</c:forEach>
			
		
		</table>
	</div>
	
</body>
</html>