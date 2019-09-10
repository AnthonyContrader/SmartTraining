<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.GroupDTO"%>
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

<%GroupDTO g = (GroupDTO) request.getAttribute("dto");%>


<form id="floatleft" action="GroupServlet?mode=update&id=<%=g.getGroupcol()%>" method="post">
  <div class="row">
    <div class="col-25">
     <label for="groupcol">groupcol</label>
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
      <input 
      		 type="text" id="group" name="idStudent" value=<%=g.getIdStudent()%>>
    </div>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>