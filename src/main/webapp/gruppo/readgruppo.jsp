<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.GruppoDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Gruppo Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Gruppo</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	
	<br>

	<div class="main">
		<%
		GruppoDTO g = (GruppoDTO) request.getSession().getAttribute("dto");
		%>


		<table>
				<tr>
				<th>Grupponame</th>
				<th>id_student</th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<td><%=g.getId()%></td>
				<td><%=g.getGrupponame()%></td>
				<td><%=g.getIdStudent()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>