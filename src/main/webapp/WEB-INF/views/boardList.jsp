<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script>
function getData(field,word,pageNum){
	$("#container").load("getList",{"field":field,"word":word,"pageNum":pageNum},function(data){
		$("#container").html(data);
	})
}
</script>
</head>
<body>
	<div align="center" id = "container">
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
		<div id = "page">
		<!-- 이전 -->
			<c:if test="${startPage>blockPage }">
				<a href="javascript:getData('${field }','${word }',${startPage-blockPage })">[이전]</a>
			</c:if>
			<!-- 페이지출력 -->
			<c:forEach begin="${startPage }" end="${endPage }" var="i">
				<c:if test="${currentPage eq i}" >
					${i }
				</c:if>
				<c:if test="${currentPage ne i}" >
					<a href="javascript:getData('${field }','${word }',${i })">${i }</a>
				</c:if>
			</c:forEach>
			<!-- 다음 -->
			<c:if test="${endPage<totPage }">
				<a href="javascript:getData('${field }','${word }',${endPage+1 })">[다음]</a>
			</c:if>
		</div>
		<div id = "search">
			<form action="getList">
				<div class="col-xs-1" id="select">
				   <select id="field" class="form-control" name="field">
				      <option value="title"> 제목
				      <option value="writer"> 작성자
				   </select>
				</div>
				<div class="col-xs-2">
				   <input type='text' id='word' name='word'  class="form-control" placeholder="검색어입력">
				</div>
				   <input type="submit" class="btn btn-default" value="검색">
			</form>
		</div>
	</div>
	
</body>
</html>