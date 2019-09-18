<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.GruppoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Gruppo Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Gruppo</title>

</head>
<body>
<%@ include file="/css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/gruppo/getall">Gruppi</a>
  <a href="/gruppo/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%GruppoDTO g = (GruppoDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/gruppo/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Grupponame</label>
    </div>
    <div class="col-75">
      <input type="text" id="gruppo" name="gruppo" value=<%=g.getGrupponame()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="gruppo">IdStudent</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="IdStudent" name="idStudent" value=<%=g.getIdStudent()%>> 
    </div>
  </div>
 <input type="hidden" name="idd" value =<%=g.getId() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="/css/footer.jsp" %>	
</body>
</html>