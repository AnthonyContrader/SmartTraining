<%@ page language="java" 
    import="java.util.*"
    import="it.contrader.dto.StudentDTO"
     import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Student Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Student Manager</title>
</head>
<body>
<%@ include file="/css/header.jsp"%>

	<div class="main">
		<%
			List<StudentDTO> list = (List<StudentDTO>) request.getSession().getAttribute("list");
		    List<UserDTO> Userlist = (List<UserDTO>) request.getSession().getAttribute("Userlist");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (StudentDTO s : list) {
			%>
			<tr>
				<td><a href="/student/read?id=<%=s.getId()%>"> <%=s.getName()%>
				</a></td>
				<td><%=s.getSurname()%></td>
				<td><%=s.getUser().getId()%></td>
				<td><a href="/student/preupdate?id=<%=s.getId()%>">Edit</a></td>


				<td><a href="/student/delete?id=<%=s.getId()%>">Delete</a></td>

			</tr>
			 <%
				}
			%>
		</table>



		<form id="floatright" action="/student/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="inserisci nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="user">Surname</label>
				</div>
				<div class="col-75">
					<input type="text" id="surname" name="surname"
						placeholder="inserisci cognome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="user">Username</label>
				</div>
			<div class="col-75">
			<select id ="User" name ="user" >
					<%
					  for (UserDTO u : Userlist) {
					%>
					<option value=<%=u.getId()%>><%=u.getUsername()%></option>
					<%
					}
					%>
					</select>
					</div>
					</div>
			<button type="submit">Insert</button>
		</form>

	<br>
	<%@ include file="/css/footer.jsp"%>

</body>
</html>