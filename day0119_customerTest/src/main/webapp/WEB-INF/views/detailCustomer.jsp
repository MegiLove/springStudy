<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객 상세</h2>
	<hr>
	고객번호 : ${c.custid } <br>
	고객이름 : ${c.name } <br>
	고객주소 : ${c.address } <br>
	고객전화 : ${c.phone } <br>
	<hr>
	<a href="updateCustomer.do?custid=${c.custid }">수정</a>
	<!-- 
		"수정"이라는 작업도 
		"등록"처럼
				수정을 위한 입력양식을 요청하는 서비스와 
				실제로 데이터베이스에 수정하는 요청
				두개의 요청이 한 세트로 이루어져야합니다.
				
				그런데, 아까 "등록"에 대한 get방식은
					딱히 할일없고 
					view페이지로 이동만 하면 되었어요.
					
					그러나 "수정"에 의한 get방식은
					수정할 정보를 dao를 통해 갖고 와서
					상태유지하고 view페이지로 가야합니다.
					
		"수정"에 대한 기능을 구현 해 봅니다.
		완성하면 "1"
					
	 -->
</body>
</html>












