<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/joinForm.css">

<title>YJ's PBK</title>
</head>
<body>
	<form action="JoinServlet" method="post">
		이름: <input type="text" name="name" placeholder="이름 입력란" size="10"><br/>
		아이디: <input type="text" name="id" placeholder="아이디 입력란" size="10"><br/>
		비밀번호: <input type="password" name="pw" placeholder="비밀번호 입력란" size="10"><br/>
		전화번호: 
			<select name="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="019">019</option>
			</select>
		- <input type="text" name="phone2" placeholder="XXXX" size="10">			
		- <input type="text" name="phone3" placeholder="XXXX" size="10"><br/>
		성별: <input type="radio" name="gender" value="남자">남자
			 <input type="radio" name="gender" value="여자">여자<br/>
		<button>회원가입</button>
	</form>
	<div class="joinformbackground">
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
		charSet = '회원가입'; // Hex
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
</body>
</html>