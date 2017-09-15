<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Student Personal Details</title>
<style>
div {
	background-color: linen;
}
</style>
</head>
<body>
	<script src="studentDetailsValidation.js"></script>
	<center>

		<div id="divid">
			<h1>Enter Student Personal Data..</h1>
			<br>

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


			<form action="studentEducationDetails.jsp" method="post">
				<table>
					<tr>
						<p id="nameMessage"></p>
						<td>Student Name:</td>
						<td><input type="text" name="name" id="name" required
							onchange="validateName()"></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="email" name="email" id="email" required></td>
					</tr>
					<tr>
						<td>Father Name:</td>
						<td><input type="text" name="fatherName" id="fatherName"
							required onchange="validateFatherName()"></td>
					</tr>
					<tr>
						<td>Mother Name:</td>
						<td><input type="text" name="motherName" id="motherName"
							required onchange="validateMotherName()"></td>
					</tr>

					<tr>
						<td>Gender:</td>
						<td><input type="radio" name="gender" value="male" checked>
							Male <input type="radio" name="gender" value="female">
							Female <input type="radio" name="gender" value="other">
							Other</td>
					</tr>




					<tr>
						<td></td>
						<td><input type="submit" value="Next" name="action"></td>
				</table>

			</form>
		</div>
	</center>

</body>
</html>