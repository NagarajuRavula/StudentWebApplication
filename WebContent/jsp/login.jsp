<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/style/login.css>
</head>
<body>
	<script src=${pageContext.request.contextPath}/js/loginValidations.js></script>
	<center>
	<div class="header">
		<h2 >Student Management Application</h2>

		<h3 >please Login to continue....</h3>
	</div>	
		<%!String message = "";
		%>
		<%
			message = (String) request.getAttribute("message");
		%>
		<%
			if (message != null) {
		%>
		<p><%=message%></p>
		<%} %>

	</center>



<div class="login-page">
  <div class="form">
    <form class="login-form" action=${pageContext.request.contextPath}/authentication method="post">
      <input type="email" placeholder="email" name="email" id="name" onchange="checkNameLength()" required />
      <input type="password" placeholder="password" name="password" id="password" onchange="checkPasswordLength()" required />
      <button>login</button>
    </form>
  </div>
</div>
</body>
</html>