<%@ page language="java" import="it.contrader.dto.ContentDTO" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Content Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Content Manager</title>

</head>
<body>
	<%@ include file="/css/header.jsp"%>

	<div class="main">
		<%
			List<ContentDTO> list = (List<ContentDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Tag</th>
				<th>Title</th>
				<th>Text</th>
				<th>IdTraining</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ContentDTO c : list) {
			%>
			<tr>
				<td><a href="/content/read?id=<%=c.getId()%><%=c.getTag()%><%=c.getTitle()%><%=c.getText()%><%=c.getIdTraining()%>"> 
				</a></td>
				<td><%=c.getTag()%></td>
				<td><%=c.getTitle()%></td>
				<td><%=c.getText()%></td>
				<td><%=c.getIdTraining()%></td>
				<td><a href="/content/preupdate?id=<%=c.getId()%>">Edit</a></td>


				<td><a href="/content/delete?id=<%=c.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/content/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="content">Tag</label>
				</div>
				<div class="col-75">
					<input type="text" id="tag" name="tag"
						placeholder="inserisci il tag">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="content">Title</label>
				</div>
				<div class="col-75">
					<input type="text" id="title" name="title"
						placeholder="inserisci il titolo">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="content">Text</label>
				</div>
				<div class="col-75">
					<input type="text" id="text" name="text"
						placeholder="inserisci il testo">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="content">Title</label>
				</div>
				<div class="col-75">
					<input type="text" id="title" name="title"
						placeholder="inserisci il titolo">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="content">IdTraining</label>
				</div>
				<div class="col-75">
					<input type="text" id="training" name="idtraining"
						placeholder="inserisci l'id del training">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="/css/footer.jsp"%>
</body>
</html>