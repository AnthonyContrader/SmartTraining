<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.StudentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Student Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%StudentDTO s = (StudentDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/student/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=s.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Surname</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="surname" name="surname" value=<%=s.getSurname()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">IdUser</label>
    </div>
   		 <div class="col-75">
 			<input type="number" name="idUser" id="idUser" value=<%=s.getIdUser() %>>
    	</div>
    	<input type="hidden" name="id" value =<%=s.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>