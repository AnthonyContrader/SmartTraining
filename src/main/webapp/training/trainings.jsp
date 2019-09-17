<%@ page language="java" 
    import="java.util.*"
    import="it.contrader.dto.TrainingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Training Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Training Manager</title>
</head>
<body>
<%@ include file="/css/header.jsp"%>

	<div class="main">
		<%
			List<TrainingDTO> list = (List<TrainingDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>NameTraining</th>
				<th>IdGroup</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (TrainingDTO t : list) {
			%>
			<tr>
				<td><a href="/training/read?id=<%=t.getId()%>"> <%=t.getNameTraining()%>
				</a></td>
				<td><%=t.getIdGroup()%></td>
				<td><a href="/training/preupdate?id=<%=t.getId()%>">Edit</a></td>


				<td><a href="/training/delete?id=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/training/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">NameTraining</label>
				</div>
				<div class="col-75">
					<input type="text" id="nameTraining" name="nameTraining"
						placeholder="inserisci nomeTraining">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="type">IdGroup</label>
				</div>
				<div class="col-75">
					<input type="number" id="idGroup" name="idGroup"
						placeholder="inserisci id Group">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="/css/footer.jsp"%>

</body>
</html>