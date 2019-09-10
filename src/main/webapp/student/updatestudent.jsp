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

<br>
<div class="main">

<%StudentDTO u = (StudentDTO) request.getAttribute("dto");%>


<form id="floatleft" action="StudentServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="student">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="student" name="name" value=<%=u.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Password</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="surname" name="surname" value=<%=u.getSurname()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">idUser</label>
    </div>
   		 <div class="col-75">
 		<input type="text" id="iduser" name="idUser" placeholder="inserisci idUser"> 
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>