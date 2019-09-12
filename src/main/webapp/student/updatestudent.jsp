<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.StudentDTO"
    import = "it.contrader.dto.UserDTO"
    import = "java.util.List"%>
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

<%StudentDTO s = (StudentDTO) request.getAttribute("dto");

  List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("listUser");%>


<form id="floatleft" action="StudentServlet?mode=update&id=<%=s.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="student">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="student" name="name" value=<%=s.getName() %>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="surname">Surname</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="surname" name="surname" value=<%=s.getSurname()%>> 
    </div>
  </div>
  <div class="row">
  	<div>
  	<label for="idUser"> idUser
  	</label>
  	</div>
    <div class="col-75">
      <select name="idUser">
			<%
				for (UserDTO u : listUser) {
			%>
			<option value=<%=u.getId()%>><%=u.getUsername()%></option>
			<%
				}
			%>
   		 	</select> 
  	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>