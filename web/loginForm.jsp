<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 프로그램</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		아이디: <input type="text" name="id"><br/>
		비밀번호: <input type="password" name="pw"><br/>
		<input type="submit" value="로그인">
	</form>
	<a href="JoinServlet">회원가입</a>
</body>
</html>