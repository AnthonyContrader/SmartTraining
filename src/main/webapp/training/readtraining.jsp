<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrainingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Training</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<br>

<div class="main">
<%TrainingDTO u = (TrainingDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>nameTraining</th>
		<th>idGroup</th>
		
	</tr>
	<tr>
		<td><%=u.getNameTraining()%></td>
		<td> <%=u.getIdGroup()%></td>
		
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