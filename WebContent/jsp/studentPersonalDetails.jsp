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
		<h2 >Student Management Application</h2>

	</div>	

			<%!String message = "";%>
			<%
			    
				message = (String) request.getAttribute("message");
			%>
			<%
				if (message != null) {
			%>
			<p><%=message%></p>
			<%
				}
			%>


<!-- 			<form action="studentEducationDetails.jsp" method="post"> -->
<!-- 				<table> -->
<!-- 					<tr> -->
<!-- 						<p id="nameMessage"></p> -->
<!-- 						<td>Student Name:</td> -->
<!-- 						<td><input type="text" name="name" id="name" required -->
<!-- 							onchange="validateName()"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>Email:</td> -->
<!-- 						<td><input type="email" name="email" id="email" required></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>Father Name:</td> -->
<!-- 						<td><input type="text" name="fatherName" id="fatherName" -->
<!-- 							required onchange="validateFatherName()"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>Mother Name:</td> -->
<!-- 						<td><input type="text" name="motherName" id="motherName" -->
<!-- 							required onchange="validateMotherName()"></td> -->
<!-- 					</tr> -->

<!-- 					<tr> -->
<!-- 						<td>Gender:</td> -->
<!-- 						<td><input type="radio" name="gender" value="male" checked> -->
<!-- 							Male <input type="radio" name="gender" value="female"> -->
<!-- 							Female <input type="radio" name="gender" value="other"> -->
<!-- 							Other</td> -->
<!-- 					</tr> -->




<!-- 					<tr> -->
<!-- 						<td></td> -->
<!-- 						<td><input type="submit" value="Next" name="action"></td> -->
<!-- 				</table> -->

<!-- 			</form> -->
<div class="container">  
  <form id="contact" action="" method="post">
    <h3>Student registration form</h3>
    <h4>Enter the student personal data</h4>
    <fieldset>
      <input placeholder="Enter name" type="text" name="name" id="name" tabindex="1" required autofocus>
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
       <option>Male</option>
       <option>Female</option>
       <option>Other</option>
       </select>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>
    <p class="copyright">Designed by <a href="https://colorlib.com" target="_blank" title="Colorlib">Colorlib</a></p>
  </form>
</div>


	</center>

</body>
</html>