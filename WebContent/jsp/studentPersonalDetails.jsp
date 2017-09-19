<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Student Personal Details</title>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/style/studentPersonalDetails.css>
</head>
<body>
	<script src="studentDetailsValidation.js"></script>
	<center>
     <div class="header">
		<h1>Student Management Application</h1>

	</div>	

			<%!String message = "";%>
			<%
			    
				message = (String) request.getAttribute("message");
			%>
			<%
				if (message != null) {
			%>
			<p id="message"><%=message%></p>
			<%
				}
			%>
<div class="container">  
  <form id="contact" action="studentEducationDetails.jsp" method="post">
    <h3>Student registration form</h3>
    <h4>Enter the student personal data</h4>
    <fieldset>
      <input placeholder="Enter name" type="text" name="name" id="name" tabindex="1"  required autofocus>
    </fieldset>
    <fieldset>
      <input placeholder="Enter Email Address" type="email" id="email" name="email" tabindex="2" required>
    </fieldset>
    <fieldset>
      <input placeholder="Enter Father Name" type="text" tabindex="3" id="fatherName" name="fatherName" required>
    </fieldset>
    <fieldset>
      <input placeholder="Enter Mother Name" type="text" tabindex="4" id="motherName" name="motherName" required>
    </fieldset>
    <fieldset>
      <select   name="gender" id="gender" >
      <option>Gender</option>
       <option>Male</option>
       <option>Female</option>
       <option>Other</option>
       </select>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="personal-submit">Next</button>
    </fieldset>
  </form>
</div>


	</center>

</body>
</html>