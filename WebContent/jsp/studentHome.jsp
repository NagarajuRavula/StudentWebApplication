<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import ="com.studentwebapplication.model.Student"
	import="com.studentwebapplication.serviceimpl.*"
	import="com.studentwebapplication.service.*"
	import="com.studentwebapplication.servicefactory.*"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Student Home</title>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/style/studentHome.css>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<script src=${pageContext.request.contextPath}/js/temp.js></script>
	<center>
	<div class="header">
		<h2 >Student Management Application</h2>

	</div>
	<%!int studentId=0; %>
	<%studentId=(Integer)session.getAttribute("studentId"); 
	StudentManagementService studentManagementService = (StudentManagementService) ObjectFactory
			.getInstance(StudentManagementServiceImpl.class);

	Student student = studentManagementService.getStudentById(studentId);
%>
	  
	
	
	
	
	
	
	
	
	<p id="logedInName">Logged in As: <b id="email"><%=student.getEmail() %></b></p>
	<a id="logout" href="jsp/login.jsp" > Log out<i class="fa fa-sign-out"></i></a>
	 <h2> welcome <%=student.getName() %></h2>
	 
	 <h3>Profile Information</h3>
	 
	 <div class="tableDiv">
	<table border='1' width='100%'>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Father Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>View/Edit</th>
		</tr>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getFatherName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getGender()%></td>
			<td><a href='jsp/editStudentDetails.jsp?id=<%=student.getId()%>'>View/Edit</a></td>
		</tr>
		</table>
	</div>
		
		
	</center>
</body>
</html>