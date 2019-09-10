<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ContentDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Content</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<% ContentDTO c = (ContentDTO) request.getAttribute("dto"); %>

<form id="floatleft" action="ContentServlet?mode=update&id=<%=c.getId()%>" method="post">
	<div class="row">
		<div class="col-25">
			<label for="tag">Tag</label>
		</div>
		<div class="col-75">
			<input type="text" id="tag" name="tag" value=<%c.getTag();%>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="title">Title</label>
		</div>
		<div class="col-75">
			<input 
					type="text" id="title" name="title" value=<%c.getTitle(); %>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="text">Text</label>
		</div>
		<div class="col-75">
			<input 
					type="text" id="text" name="text" value=<%c.getText(); %>>
		</div>
	</div>
	<div>
		<div>
			<label for="type">idStudent</label>
		</div>
			<div class="col-75">
					<input type="number" id="idStudent" name="idStudent" value=<%c.getIdStudent(); %>>
			</div>
	</div>
		<button type="submit">Edit</button>
</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>