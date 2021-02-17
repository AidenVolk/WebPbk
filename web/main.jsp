<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/css/bootstrap.css">
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
<h1>회원관리 페이지</h1>
<h3>${name }님의 전화번호부</h3>
<a href="LogoutServlet">로그아웃</a><br/><br/>
<a href="UpdateLoginServlet">나의 정보수정</a><br/><br/>
<a href="InsertServlet">연락처 추가</a><br/><br/>
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="검색할 이름을 입력하세요" size="20">
<table id="myTable" border="1">
	<tr>
		<th>이름</th><th>연락처</th><th>그룹명</th><th>수정</th><th>삭제</th>
	</tr>
	<c:forEach items="${login }" var="person">
		<tr>
			<td>${person.name }</td>
			<td>${person.phone1} - ${person.phone2 } - ${person.phone3 }</td>
			<td>${person.gpnm }</td>
			<td><a href="UpdatePbkServlet?num=${person.num }" class="btn btn-danger">수정</a></td>
			<td><a href="DeletePbkServlet?num=${person.num }">삭제</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>