<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TrainingDTO"%>
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
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="StudentServlet?mode=studentlist">Students</a>
  <a href="ContentServlet?mode=contentlist">Contents</a>
  <a class="active" href="TrainingServlet?mode=traininglist">Training</a>
  <a href="GroupServlet?mode=grouplist">Groups</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
	<%
		List<TrainingDTO> list = (List<TrainingDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>nameTraining</th>
			<th>idGroup</th>
			<th>idStudent</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (TrainingDTO u : list) {
		%>
		<tr>
			<td><a href=TrainingServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getNameTraining()%>
			</a></td>
			<td><%=u.getIdGroup()%></td>
			<td><%=u.getIdStudent()%></td>
			<td><a href=TrainingServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=TrainingServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="TrainingServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">nameTraining</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="nameTraining" placeholder="inserisci nameTraining">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">idGroup</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="idGroup" placeholder="inserisci idGroup"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">idStudent</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="idStudent">
  				<option value="idStudent1">idStudent1</option>
  				<option value="idStudent2">idStudent2</option>
 
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