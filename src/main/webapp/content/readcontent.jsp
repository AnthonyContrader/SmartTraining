<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ContentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Content</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<br>

<div class="main">
<%ContentDTO c = (ContentDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>title</th>
		<th>text</th>
		<th>tag</th>
		<th>idStudent</th>
	</tr>
	<tr>
		<td><%=c.getTag()%></td>
		<td> <%=c.getTitle()%></td>
		<td> <%=c.getText()%></td>
		<td> <%=c.getIdTraining()%></td>
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