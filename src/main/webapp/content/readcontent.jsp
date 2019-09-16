<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ContentDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Content Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Content</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	
	<br>

	<div class="main">
		<%
			ContentDTO c = (ContentDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Tag</th>
				<th>Title</th>
				<th>Text</th>
				<th>IdTraining</th>
			</tr>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getTag()%></td>
				<td><%=c.getTitle()%></td>
				<td><%=c.getText()%></td>
				<td><%=c.getIdTraining()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>