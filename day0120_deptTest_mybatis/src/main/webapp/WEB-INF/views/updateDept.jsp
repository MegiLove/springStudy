<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서수정</h2>
	<hr>
	<form action="updateDept.do" method="post">
		<br>
		부서번호 : ${d.dno }<br>
		<input type="hidden" name="dno" value="${d.dno }">
		부서이름 : <input type="text" name="dname" value="${d.dname }"><br>
		부서위치 : <input type="text" name="dloc" value="${d.dloc }"><br>
		<hr>
		<input type="submit" value="수정">
	</form>
	
	<!-- 부서번호는 수정하는 것이 아니니
			사용자가 아예 입력을 못하도록 하고 싶어요! 
		
		그렇다 지워버리면 곤란해요.
		수정할 때에 부서번호가 있어야 합니다.
		
		그럼 어떡해요?
			사용자 화면에 보이지는 않지만
			서버에게 값을 전달해 주기 위하여 
			<input type="hidden">을 사용합니다.
			-->
</body>








</html>