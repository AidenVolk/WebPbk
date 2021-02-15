<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="InsertServlet" method="post">
		연락처 소유자 아이디: ${id }<br/>
		이름<input type="text" name="name" size="10" ><span style="color:red">${msgName }</span><br/>
		전화번호: 
			<select name="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="019">019</option>
			</select>
		-<input type="text" name="phone2" size="5">
		-<input type="text" name="phone3" size="5"><span style="color:red">${msgNumber }</span><br/>
		그룹<input type="radio" name="gpnm" value="1">가족
		   <input type="radio" name="gpnm" value="2">친구
		   <input type="radio" name="gpnm" value="3">기타
		   <span style="color:red">${msgGroup }</span><br/>
		<input type="submit" value="추가">   
	</form>
</body>
</html>