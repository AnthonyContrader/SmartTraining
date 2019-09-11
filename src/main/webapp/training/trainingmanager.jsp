<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TrainingDTO" import = "it.contrader.dto.GroupDTO"%>
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
		List<TrainingDTO> list = (List<TrainingDTO>) request.getAttribute("list");
		List<GroupDTO> listgroup = (List<GroupDTO>) request.getAttribute("listgroup");
	%>

<br>

	<table>
		<tr>
			<th>nameTraining</th>
			<th>GroupName</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (TrainingDTO u : list ) {
		%>
		<tr>
			<td><a href=TrainingServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getNameTraining()%>
			</a></td>
			<td><%=u.getIdGroup() %></td>
			<td><a href=TrainingServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=TrainingServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="TrainingServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nametraining">nameTraining</label>
    </div>
    <div class="col-75">
      <input type="text" id="nametraining" name="nameTraining" placeholder="inserisci nameTraining">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="idgroup">idGroup</label>
    </div>
    <div class="col-75">
      <select name="idGroup">
      	<% for (GroupDTO g : listgroup){ %>
      		<option value = <%= g.getId() %>> <%= g.getGroupcol() %></option>
      	<% } %>
      </select> 
    </div>
  </div>
  
  
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>