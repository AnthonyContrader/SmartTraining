<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List" 
	import="it.contrader.dto.ContentDTO"
	import="it.contrader.dto.TrainingDTO"
	 %>
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

<% ContentDTO c = (ContentDTO) request.getAttribute("dto");
List<ContentDTO> list = (List<ContentDTO>) request.getAttribute("list");
List<TrainingDTO> list2DTO = (List<TrainingDTO>) request.getAttribute("list2DTO");

%>

<form id="floatleft" action="ContentServlet?mode=update&id=<%=c.getId()%>" method="post">
	<div class="row">
		<div class="col-25">
			<label for="tag">Tag</label>
		</div>
		<div class="col-75">
			<input type="text" id="tag" name="tag" value=<%=c.getTag()%>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="title">Title</label>
		</div>
		<div class="col-75">
			<input 
					type="text" id="title" name="title" value=<%=c.getTitle() %>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="text">Text</label>
		</div>
		<div class="col-75">
			<input 
					type="text" id="text" name="text" value=<%=c.getText() %>>
		</div>
	</div>
	
 
	<div class="row">
	
		<div class="col-25">
			<label for="IdTraining">NameTraining</label>
		</div>
			
			<div class=>
			 <select name="IdTraining">   
  	    <%
		for (TrainingDTO t : list2DTO) {
			
		%>
  				
  		<option value=<%=t.getId()%>> <%=t.getNameTraining()%> </option>
  		<%
			}
		%>
			</select>			
		   </div>
		
		
	</div>
				
	
		<button type="submit">Edit</button>
</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>