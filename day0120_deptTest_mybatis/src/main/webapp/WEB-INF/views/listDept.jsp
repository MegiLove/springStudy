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
	<h2>부서목록</h2>
	<hr>
	<a href="insertDept.do">등록</a><br>
	<table border="1" width="80%">
		<tr>
			<td>부서번호</td>			
		</tr>
		<c:forEach var="d" items="${list }">
			<tr>
				<td>
					<a href="detailDept.do?dno=${d.dno }">${d.dno }</a>
				</td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>







