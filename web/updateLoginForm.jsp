<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/updateLoginForm.css">

<title>YJ's PBK</title>
</head>
<body>
<div class="updateloginbackground">
	<span>
		<canvas id='cvs'></canvas>
		
		<script>
		// Get canvas
		var cvs = document.getElementById('cvs');
		
		// Canvas fills window
		cvs.height = window.innerHeight;
		cvs.width = window.innerWidth;
		
		// Get canvas context
		var ctx = cvs.getContext('2d');
		
		// Set font, size & number of columns
		var font = 'arial';
		var fontSize = 14;
		ctx.font = fontSize + 'px ' + font;
		var cols = cvs.width / fontSize;
		
		// Characters
		var charSet;
		charSet = '회원정보 수정'; // Hex
		charSet = charSet.split(''); // Convert string to array
		
		// One drop per column, row set randomly
		var drops = [];
		for (var col = 0; col < cols; col++)
		  drops[col] = Math.floor(Math.random() * cvs.height);
		
		// Call rain() every 25ms
		setInterval(rain, 35);
		
		function rain() {
		  // Background, black, translucent
		  /* This is key to the fade effect, clear the window with an alpha of 0.05, which doesn't clear it entirely but leaves existing text progressively dimmed with each subsequent call to rain()
		   */
		  ctx.fillStyle = 'rgba(0, 0, 0, 0.05)';
		  ctx.fillRect(0, 0, cvs.width, cvs.height);
		  
		  // For each column / drop
		  for (var col = 0; col < drops.length; col++) {
		    // Pick a random char
		    var char = charSet[Math.floor(Math.random() * charSet.length)];
		    // Pick a random colour
		    ctx.fillStyle = randColour();
		    // Draw the char
		    ctx.fillText(char, col * fontSize, drops[col] * fontSize);
		    // Randomly reset drop back to top row
		    if (Math.random() > 0.99)
		      drops[col] = 0;
		
		    drops[col]++; // Move drop down a row
		  }
		}
		
		function randColour()
		{
		  return'rgb(' + 
		    Math.floor(Math.random() * 256) + ',' + 
		    Math.floor(Math.random() * 256) + ',' + 
		    Math.floor(Math.random() * 256) + ')';
		}
		</script>
	</span>
	</div>
	<h3>나의 정보 수정 페이지</h3>
	<form action="UpdateLoginServlet" method="post">
	<div class="name">
	이름: <input type="text" name="name" size="10" value="${person.name }"><br/>
	</div>
	<div class="id">
	소유자 아이디: ${person.id }<br/>
	</div>
	<div class="pw">
	비밀번호:  <input type="password" name="pw" placeholder="새 비밀번호 입력란" size="15"><br/>
	</div>
	<div class="select">
	전화번호:
		<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="019">019</option>
		</select>
		- <input type="text" name="phone2" size="10" value="${person.phone2 }">
		- <input type="text" name="phone3" size="10" value="${person.phone3 }"><br/>
	</div>
	<div class="r">
		<c:if test="${person.gender =='남자' }">
			성별: <input type="radio" name="gender" value="남자" checked="checked">남
				 <input type="radio" name="gender" value="여자">여
		</c:if>
		<c:if test="${person.gender =='여자' }">
			성별: <input type="radio" name="gender" value="남자">남
				 <input type="radio" name="gender" value="여자" checked="checked">여
		</c:if>
	</div>
	<br/>
	<br/>
	<div class="updatebtn">
	<input type="submit" value="정보수정">
	</div>
	</form>
</body>
</html>