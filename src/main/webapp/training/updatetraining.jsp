<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrainingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Training</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<%TrainingDTO u = (TrainingDTO) request.getAttribute("dto");%>


<form id="floatleft" action="TrainingServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="training">nameTraining</label>
    </div>
    <div class="col-75">
      <input type="text" id="training" name="nameTraining" value=<%=u.getNameTraining()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Password</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="idgroup" name="idGroup" value=<%=u.getIdGroup()%>> 
    </div>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>