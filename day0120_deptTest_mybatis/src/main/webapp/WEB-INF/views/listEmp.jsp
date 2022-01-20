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
	<h2>사원 목록</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>사원번호</td>
			<td>사원이름</td>
		</tr>
		<c:forEach var="e" items="${list }">
			<tr>
				<td>${e.eno }</td>
				<td>${e.ename }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>






