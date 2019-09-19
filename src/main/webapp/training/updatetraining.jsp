<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrainingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Training Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>

</head>
<body>
<%@ include file="/css/header.jsp" %>

<br>
<div class="main">

<% TrainingDTO t = (TrainingDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/training/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="training">NameTraining</label>
    </div>
    <div class="col-75">
      <input type="text" id="nameTraining" name="nameTraining" value=<%=t.getNameTraining()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="training">Gruppo</label>
    </div>
   		 <div class="col-75">
 			<input type="number" id="Gruppo" name="Gruppo"  value=<%=t.getGruppo() %>>
    	</div>
  </div>
  	<input type="hidden" name="id" value =<%=t.getGruppo().getGrupponame() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="/css/footer.jsp" %>	
</body>
</html>