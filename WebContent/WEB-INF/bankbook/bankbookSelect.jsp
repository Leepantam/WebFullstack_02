<%@page import="com.leepantam.s1.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	BankBookDTO bDto = (BankBookDTO)request.getAttribute("search");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



</head>
<body>

<div class="container">
		<div class="row">

			<h1>BankBookSelect</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>name</th>
						<th>rate</th>
						<th>can</th>

					</tr>
				</thead>
				<tbody>
				<% if(bDto!=null){ %>
					<tr>
						<td><%=bDto.getACCOUNT_NAME() %></td>
						<td><%=bDto.getINTEREST_RATE() %></td>
						<td><%=bDto.getCAN_MAKE() %></td>
					</tr>
					<% } %>
				</tbody>
			</table>
			<div>
				<button><a href="./bankbookList.do">리스트</a></button>
			</div>
		</div>
	</div>

</body>
</html>