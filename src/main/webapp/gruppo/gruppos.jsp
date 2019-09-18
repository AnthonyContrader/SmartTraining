<%@ page language="java" 
import="it.contrader.dto.GruppoDTO" 
import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Gruppo Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Gruppo Manager</title>

</head>
<body>
	<%@ include file="/css/header.jsp"%>

	<div class="main">
		<%
			List<GruppoDTO> list = (List<GruppoDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Grupponame</th>
				<th>id_student</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (GruppoDTO g : list) {
			%>
			<tr>
				<td><a href="/gruppo/read?id=<%=g.getId()%>"> <%=g.getGrupponame()%>
				</a></td>
				<td></td>
				<td><%=g.getIdStudent()%></td>
				<td><a href="/gruppo/preupdate?id=<%=g.getId()%>">Edit</a></td>

				<td><a href="/gruppo/delete?id=<%=g.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/gruppo/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Grupponame</label>
				</div>
				<div class="col-75">
					<input type="text" id="gruppo" name="gruppo"
						placeholder="inserisci Grupponame">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="idstudent">IdStudent</label>
				</div>
				<div class="col-75">
					<input type="text" id="idStudent" name="idStudent"
						placeholder="inserisci IdStudent">
				</div>
			</div>
	
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="/css/footer.jsp"%>
</body>
</html>