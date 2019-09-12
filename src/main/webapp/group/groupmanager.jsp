<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"
import="it.contrader.dto.GroupDTO" import="it.contrader.dto.StudentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="main">
	<%
		List<GroupDTO> list = (List<GroupDTO>) request.getAttribute("list");
	    List<StudentDTO> studentlist = (List<StudentDTO>) request.getAttribute("studlist");
	%>
<br>

	<table>
		<tr>
				<th>IdStudent</th>
				<th>Groupcol</th>
				<th>Id</th>			
			</tr>
			<%
			for(GroupDTO g : list) {
				
			%>
			<tr>
			<td><a href=GroupServlet?mode=read&id=<%=g.getId() %>>
				<%=g.getIdStudent() %>
			</a></td>
			<td><%=g.getGroupcol() %></td>
			<td><%=g.getId()%> </td>
			<td><a href=GroupServlet?mode=read&update=true&id=<%=g.getId() %>>Edit</a>
			</td>
			<td><a href=GroupServlet?mode=delete&id=<%=g.getId() %>>Delete</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	
	
	<form id="floatright" action="GroupServlet?mode=INSERT" method="post">
		<div class="row">
			<div class="col-25">
				 <label for="idStudent">idStudent</label>
			</div>
			<div class="col-75">
			<select id="groupcol" name="idStudent">
			<% 
      	for (StudentDTO s : studentlist){ %>
      		<option  value = <%= s.getId() %>><%= s.getName() %></option>  
      		
      	<% } %>
      </select>
      </div>    
            </div>    
      
      
      	 <div class="row">
   			 <div class="col-25">
   		 		  <label for="groupcol">nameGroup</label>
   			 </div>
			<div class="col-75">
					<input type="text" id="groupcol" name="groupcol" placeholder="inserisci il nome del Grouppo">
			</div>
		</div>	
			<button type="submit"> Insert</button>
	</form>
	
</div>
<br>
	<%@ include file="../css/footer.jsp" %>
</body>
</html>
