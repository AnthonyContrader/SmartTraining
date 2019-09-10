<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.GroupDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Group</title>
</head>
<body>
<%@include file="../css/header.jsp" %>

	<br>
	<div class="main">
	<%GroupDTO u = (GroupDTO) request.getAttribute("dto"); %>
	<table>
	<tr>
		<th>idStudent</th>
		<th>groupcol</th>
		<th>id</th>
	</tr>
	<tr>
		<td><%=u.getIdStudent()%></td>
		<td><%=u.getGroupcol() %></td>
		<td><%=u.getId() %></td>
	</tr>
	</table>
	<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
	</div>
	
	<%@ include file="../css/footer.jsp" %>
</body>
</html>