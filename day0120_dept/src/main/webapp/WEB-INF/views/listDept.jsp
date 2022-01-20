<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>부서목록</h2>
	<hr>
	<a href="insertDept.do">등록</a><br>
	<table border="1" width="80%">
		<tr>
			<th>부서번호</th>			
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

<!-- 상세보기 기능을 추가 합니다.
		완성하면 "1" -->










