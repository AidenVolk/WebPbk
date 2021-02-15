<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 프로그램</title>
</head>
<body>
<h1>회원관리 페이지</h1>
<h3>${name }님의 전화번호부</h3>
<a href="LogoutServlet">로그아웃</a><br/><br/>
<a href="UpdateServlet">나의 정보수정</a><br/><br/>
<a href="InsertServlet">연락처 추가</a><br/><br/>
	<input type="text" name="selectByName" size="10">
	<input type="submit" value="검색"><br/><br/>
<table border="1">
	<tr>
		<th>이름</th><th>연락처</th><th>그룹명</th><th>수정</th><th>삭제</th>
	</tr>
	<c:forEach items="${login }" var="person">
		<tr>
			<td>${person.name }</td>
			<td>${person.phone1} - ${person.phone2 } - ${person.phone3 }</td>
			<td>${person.gpnm }</td>
			<td><a href="UpdatePbkServlet?id=${person.id }">수정</a></td>
			<td><a href="DeletePbkServlet?id=${person.id }">삭제</a></td>
		</tr>
	</c:forEach>




</table>
</body>
</html>