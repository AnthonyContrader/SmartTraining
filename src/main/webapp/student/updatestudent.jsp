<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.StudentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Student</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="StudentServlet?mode=studentlist">Student</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%StudentDTO s = (StudentDTO) request.getAttribute("dto");%>


<form id="floatleft" action="StudentServlet?mode=update&id=<%=s.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="student">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="student" name="name" value=<%=s.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="text">Surname</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="text" name="surname" value=<%=s.getSurname()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">IdUser</label>
    </div>
   		 <div class="col-75">
 			
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>