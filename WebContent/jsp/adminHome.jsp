<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studentwebapplication.model.*"
	import="com.studentwebapplication.serviceimpl.*"
	import="com.studentwebapplication.service.*" import="java.util.List "
	import="com.studentwebapplication.servicefactory.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/style/adminHome.css>
</head>
<body>
<script src=${pageContext.request.contextPath}/js/adminHome.js></script>

   
	<center>
	<div class="header">
		<h2 >Student Management Application</h2>

	</div>	
		<h1>Welcome Admin</h1>
		<a href="jsp/studentPersonalDetails.jsp">Add Student+</a><br> <br>
        <a href="jsp/login.jsp">Home</a><br> <br>
		<h3>Students List</h3>
	</center>

<div>

<p id="deleteMessage">

</div>
	<%
		StudentManagementService studentManagementService = (StudentManagementService) ObjectFactory
				.getInstance(StudentManagementServiceImpl.class);

		List<Student> studentList = studentManagementService.getAllStudents();
	%>
	<div class="tableDiv">
	<table border='1' width='100%'>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Father Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<%
			for (Student student : studentList) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getFatherName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getGender()%></td>
			<td><a href='jsp/editStudentDetails.jsp?id=<%=student.getId()%>'>edit</a></td>
			<td><a href='./delete?id=<%=student.getId()%>'>delete</a></td>
		</tr>

		<%
			}
		%>

	</table>
	</div>
	
	
	

<%!String message = "";%>
			<%
			    
				message = (String) request.getAttribute("deleteMessage");
			%>
			<%
				if (message != null) {
			%>
			<div class="alert">
  <span class="closebtn">&times;</span>  
  <%=message%>
</div>
			<%
				}
			%>
 
 
 <script type="text/javascript">
 
 var close = document.getElementsByClassName("closebtn");
 var i;
 console.log(close);
 console.log(close.length);
 for (i = 0; i < close.length; i++) {
     close[i].onclick = function(){
         var div = this.parentElement;
         console.log(div);
         div.style.opacity = "0";
         setTimeout(function(){ div.style.display = "none"; }, 600);
         }
}
 
 </script>

</body>
</html>