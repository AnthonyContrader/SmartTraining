<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.StudentDTO"
	import ="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Student Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<div class="main">
	<%
		List<StudentDTO> list = (List<StudentDTO>) request.getAttribute("list");
		List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("listUser");
	%>

<br>

	<table>
		<tr>
			<th>name</th>
			<th>surname</th>
			<th>Username</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (StudentDTO s : list) {
		%>
		<tr>
			<td><a href=StudentServlet?mode=read&id=<%=s.getId()%>>
					<%=s.getName()%>
			</a></td>
			<td><%=s.getSurname()%></td>
			<td><%=s.getIdUser()%> </td> 
			<!-combiare la visual di idUser in Username ->
			<td><a href=StudentServlet?mode=read&update=true&id=<%=s.getId()%>>Edit</a>
			</td>
			<td><a href=StudentServlet?mode=delete&id=<%=s.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="StudentServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="inserisci name">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="surname">surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="surname" name="surname" placeholder="inserisci surname"> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="iduser">Username</label>
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
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>