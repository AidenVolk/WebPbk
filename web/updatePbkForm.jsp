<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdatePbkServlet" method="post">
	이름: <input type="text" name="name" size="10"><br/>
	전화번호:
		<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="019">019</option>
		</select>
	- <input type="text" name="phone2" size="10" value="${person.phone2 }">
	- <input type="text" name="phone3" size="10" value="${person.phone3 }"><br/>
	<c:if test="${person.gpnm =='가족' }">
		그룹: <input type="radio" name="gpnm" value="1" checked="checked">가족
			 <input type="radio" name="gpnm" value="2">친구
			 <input type="radio" name="gpnm" value="3">기타
	</c:if>
	<c:if test="${person.gpnm =='친구' }">
		그룹: <input type="radio" name="gpnm" value="1" >가족
			 <input type="radio" name="gpnm" value="2" checked="checked">친구
			 <input type="radio" name="gpnm" value="3">기타
	</c:if>
	<c:if test="${person.gpnm =='기타' }">
		그룹: <input type="radio" name="gpnm" value="1">가족
			 <input type="radio" name="gpnm" value="2">친구
			 <input type="radio" name="gpnm" value="3" checked="checked">기타
	</c:if>
	<br/>
	<br/>
	<input type="submit" value="정보수정">
	</form>
</body>
</html>