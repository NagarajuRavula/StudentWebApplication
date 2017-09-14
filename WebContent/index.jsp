<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</head>
<body>
<script src="loginValidations.js"></script> 
<center><h2>Student Management Application</h2>

<h3>please Login to continue....</h3>

 <%! String message = ""; %> 
     <% message  = (String) request.getAttribute("message"); 
 
    %> 
    <%if(message!=null){
    %>
    <p><%=message %></p>
    <%} %>
    
    




<form action="authentication" method="post">
<p id="msg"/><br>
Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="name" id="name" required onchange="checkNameLength()"/><br><br>
Password:<input type="password" name="password" id="password" required onchange="checkPasswordLength()"/><br><br>
<input type="submit" value="Login" name="action"/><br>
</form>
</center>
</body>
</html>