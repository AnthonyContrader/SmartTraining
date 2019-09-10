<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="StudentServlet?mode=studentlist">Students</a>
  <a href="ContentServlet?mode=contentlist">Contents</a>
  <a href="TrainingServlet?mode=traininglist">Training</a>
  <a href="GroupServlet?mode=grouplist">Groups</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>



</body>
</html>