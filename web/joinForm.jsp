<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 프로그램</title>
</head>
<body>
	<form action="JoinServlet" method="post">
		이름: <input type="text" name="name" size="10"><br/>
		아이디: <input type="text" name="id" size="10"><br/>
		비밀번호: <input type="password" name="pw" size="10"><br/>
		전화번호: 
			<select name="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="019">019</option>
			</select>
		- <input type="text" name="phone2" size="10">			
		- <input type="text" name="phone3" size="10"><br/>
		성별: <input type="radio" name="gender" value="남자">남자
			 <input type="radio" name="gender" value="여자">여자<br/>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>