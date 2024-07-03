<%@page import="match.MatchDAO" %>
<%@page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>All Available Match Details Are</h2>
<table>
<tr><th>Title</th><th>Place</th><th>Match Date</th></tr>
<% 
ResultSet rs= new MatchDAO().retrieveMatch();
while(rs.next()){
%>
<tr><th><%=rs.getString(1) %></th><th><%=rs.getString(2) %></th><th><%=rs.getString(3) %></th></tr><%} %>
</table>
</body>
</html>