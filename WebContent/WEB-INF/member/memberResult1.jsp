<%@page import="com.leepantam.s1.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String)request.getAttribute("r");

	MemberDTO mDto = (MemberDTO)request.getAttribute("mDto");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Result Page</h1>
	<h1><%= result %></h1>
	<%if(mDto != null){ %>
		
	<h1><%= mDto.getNAME() %></h1>
	<h1><%= mDto.getPHONE() %></h1>
	<h1><%= mDto.getEMAIL() %></h1>

	<% } %>
</body>
</html>