<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ContentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Content Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Content</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/content/getall">Contents</a>
  <a href="/content/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ContentDTO c = (ContentDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/content/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="content">Tag</label>
    </div>
    <div class="col-75">
      <input type="text" id="tag" name="tag" value=<%=c.getTag()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="content">Title</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="title" name="title" value=<%=c.getTitle()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="content">Text</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="text" name="text" value=<%=c.getText()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="content">IdTraining</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="idt" name="idtraining" value=<%=c.getIdTraining()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>