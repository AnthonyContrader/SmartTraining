<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>


<%@include file="css/headerStudent.jsp"%>
<!--  <div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>-->
<div class="main">
<h1>Welcome ${user.getUsername()}</h1>
	


</div>
<%@ include file="css/footer.jsp" %>
</body>
</html>