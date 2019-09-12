<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.GroupDTO"
    import="it.contrader.dto.StudentDTO"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Group</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<%GroupDTO g = (GroupDTO) request.getAttribute("dto");
List<StudentDTO> studentlist = (List<StudentDTO>) request.getAttribute("studlist");%>


<form id="floatleft" action="GroupServlet?mode=update&id=<%=g.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
     <label for="groupcol">nomeGruppo</label>
    </div>
    <div class="col-75">
      <input 
      		 type="text" id="groupcol" name="groupcol" value=<%=g.getGroupcol()%>> 
    </div>
  </div>
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
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>