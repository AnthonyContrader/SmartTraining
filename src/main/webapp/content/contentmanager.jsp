<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"
import="it.contrader.dto.ContentDTO"
import="it.contrader.dto.TrainingDTO"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Content Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="main">
	<%
		List<ContentDTO> list = (List<ContentDTO>) request.getAttribute("list");
	    List<TrainingDTO> list2DTO = (List<TrainingDTO>) request.getAttribute("list2DTO");
	%>
	
<br>

	<table>
		<tr>
			<th>Tag</th>
			<th>Title</th>
			<th>Text</th>
			<th>IdTraining</th>
		</tr>
		<%
		
		for (ContentDTO c : list) {
			
		%>
		<tr>
		
			<td><a href=ContentServlet?mode=read&id=<%=c.getId()%>> <%=c.getTag()%></a></td>
			<td><%=c.getTitle()%></td>
			<td><%=c.getText()%></td>
			<td><%=c.getIdTraining()%></td>
			
			<td><a href=ContentServlet?mode=read&update=true&id=<%=c.getId()%>>Edit </a> </td>
			<td><a href=ContentServlet?mode=delete&id=<%=c.getId()%>>Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	
	
<form id="floatright" action="ContentServlet?mode=insert" method="post">
	<div class="row">
		<div class="col-25">
		  <label for="tag">Tag</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="Tag" name="tag" placeholder="inserisci tag">
    </div>
  </div>
  <div class="row">
		<div class="col-25">
		  <label for="title">Title</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="Title" name="title" placeholder="inserisci title">
    </div>
  </div>
  <div class="row">
		<div class="col-25">
		  <label for="text">Text</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="Text" name="text" placeholder="inserisci text">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idtraining">NameTraining</label>
    </div>
    
    <div class="col-75">
      
<script type="text/javascript">   //<input type="number" id="idtraining" name="IdTraining" placeholder="inserisci idTraining"></script>
      
      
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
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>