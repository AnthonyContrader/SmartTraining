<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.contrader.dto.StudentDTO"
    import="it.contrader.dto.UserDTO"
     import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Student Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>

</head>
<body>
<%@ include file="/css/header.jsp" %>

<br>
<div class="main">

<%StudentDTO s = (StudentDTO) request.getSession().getAttribute("dto");
List<UserDTO> Userlist = (List<UserDTO>) request.getSession().getAttribute("Userlist");
%>


<form id="floatleft" action="/student/update?id=<%= s.getId() %>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=s.getName()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="pass">Surname</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="surname" name="surname" value=<%=s.getSurname()%>> 
    </div>
  </div>
  
  <div class="row">
				<div class="col-25">
					<label for="user">Username</label>
				</div>
			<div class="col-75">
			<select id ="User" name ="user" >
					<%
					  	for (UserDTO u : Userlist) {
					  		System.out.println("false");	
					  				//for(int n = 0; n > userDto.size(); n++){
							  			//System.out.println("true");
							  			//if(userDto.get(n).getId() != u.getId()){
									  	//System.out.println("Dto1: " + userDto.get(n).getId() + " -  Dto2: " + u.getId());
							  
					%>
					<option value=<%=u.getId()%>><%=u.getUsername()%></option>
					<%
								//}
					  		//}
					 	}
					%>
					</select>
					</div>
					</div>
  
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="/css/footer.jsp" %>	
</body>
</html>