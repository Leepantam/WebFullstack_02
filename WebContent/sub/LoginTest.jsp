<%@page import="com.leepantam.s1.member.MemberDTO"%>
<%@page import="com.leepantam.s1.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Test JSP Page</h1>
	<%
		MemberDTO mDto = new MemberDTO();
		MemberDAO mDao = new MemberDAO();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		mDto.setID(id);
		mDto.setPW(pw);
		mDto=mDao.login(mDto);

		
		String check;
		if(mDto!=null){
			check="성공";
		}else{
			check="실패";
		}
		
	%>
	<h1>ID : <%= id %></h1>
	<h1>PW : <%= pw %></h1>
	<h1><%= check %></h1>
</body>
</html>