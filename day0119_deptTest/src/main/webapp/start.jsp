<%@page import="org.springframework.web.filter.CharacterEncodingFilter"%>
<%@page import="org.springframework.web.servlet.DispatcherServlet"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//DispatcherServlet
	//CharacterEncodingFilter
	
	response.sendRedirect("listDept.do");
%>
</body>
</html>

