<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"
import="it.contrader.dto.GroupDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title"src/main/java/it/contrader/dto/TrainingDTO.java">Group Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="main">
	<%
		List<GroupDTO> list = (List<GroupDTO>) request.getAttribute("list");
	%>
<br>

	<table>
		<tr>
				<th>IdStudent</th>
				<th>Id</th>			
			</tr>
			<%
			for(GroupDTO g : list) {
				
			%>
			<tr>
			<td><a href=GroupServlet?mode=read&id=<%=g.getId() %>>
				<%=g.getIdStudent() %>
			</a></td>
			<td><%=g.getId()%> </td>
			<td><a href=GroupServlet?mode&update=true&id=<%=g.getId() %>>Edit</a>
			</td>
			<td><a href=GroupServlet?mode=delete&id=<%=g.getId() %>>Delete</a>
			</td>
		</tr>
		<%
			}
		%>
	
	
	</table>
	<form id="floatright" action="GroupServlet?mode=insert" method="post">
		<div class="row">
			<div class="col-25">
				 <label for="group">idStudent</label>
			</div>
			<div class="col-75">
				<input type="text" id="group" name="IdStudent" placeholder="inserisci l'ID dello studente">
			</div>
			<div class="row">
				<div class="col-75">
					<label for="id">ID</label>
				</div>	
				<div class="col-75">
					<input type="text" id="Id" placeholder="inserisci l'ID">
				</div>		
			</div>
		</div>
			<button type="submit"> Insert</button>
	</form>
	
</div>
<br>
	<%@ include file="../css/footer.jsp" %>
</body>
</html>
