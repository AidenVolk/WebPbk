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
	<form action="UpdatePbkServlet" method="post">
	이름: <input type="text" name="name" size="10" value="${person.name }"><br/>
	아이디: ${id }<br/>
	비밀번호:  <input type="password" name="pw" size="10"><br/>
	전화번호:
		<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="019">019</option>
		</select>
	- <input type="text" name="phone2" size="10" value="${person.phone2 }">
	- <input type="text" name="phone3" size="10" value="${person.phone3 }"><br/>
	<c:if test="${person.gender =='남자' }">
		성별: <input type="radio" name="gender" value="남자" checked="checked">남
			 <input type="radio" name="gender" value="여자">여
	</c:if>
	<c:if test="${person.gender =='여자' }">
		성별: <input type="radio" name="gender" value="남자">남
			 <input type="radio" name="gender" value="여자" checked="checked">여
	</c:if>
	<br/>
	<br/>
	<input type="submit" value="정보수정">
	</form>
</body>
</html>