<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

<title>연락처 프로그램</title>
<script>
function myFunction() {
	  // Declare variables
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	  }
	}
</script>

</head>
<body>
	
	<div class="loginbackground">
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
		charSet = '메인'; // Hex
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
<h1>메인 페이지</h1>
<h3>${name }님의 전화번호부</h3>
<div class="logout">
<a href="LogoutServlet">로그아웃</a><br/><br/>
</div>
<div class="update">
<a href="UpdateLoginServlet">나의 정보수정</a><br/><br/>
</div>
<div class="add">
<a href="InsertServlet">연락처 추가</a><br/><br/>
</div>
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="이름 검색창" size="20">
<div class="tableform">
	<div class="table">	
	<table id="myTable" >
		<tr>
			<th>이름</th><th>연락처</th><th>그룹명</th><th>수정</th><th>삭제</th>
		</tr>
		<c:forEach items="${login }" var="person">
			<tr>
				<td>${person.name }</td>
				<td>${person.phone1} - ${person.phone2 } - ${person.phone3 }</td>
				<td>${person.gpnm }</td>
				<td><a href="UpdatePbkServlet?num=${person.num }">수정하기</a></td>
				<td><a href="DeletePbkServlet?num=${person.num }">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>