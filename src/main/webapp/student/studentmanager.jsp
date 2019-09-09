<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.StudentDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title"src/main/java/it/contrader/dto/TrainingDTO.java">Training Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="StudentServlet?mode=studentlist">Students</a>
  <a href="ContentServlet?mode=contentlist">Contents</a>
  <a class="active" href="TrainingServlet?mode=traininglist">Training</a>
  <a href="GroupServlet?mode=grouplist">Groups</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
	<%
		List<StudentDTO> list = (List<StudentDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>IdUser</th>
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
			<td><%=s.getIdUser()%></td>
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
      <label for="user">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="name" placeholder="inserisci name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" surname="Surname" placeholder="inserisci surname"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">idUser</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="idUser">
  				<option value="idStudent1">idUser1</option>
 
			</select>
    	</div>
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>