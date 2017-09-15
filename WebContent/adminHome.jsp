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
</head>
<style>
.alert {
    padding: 20px;
    background-color: #f44336;
    color: white;
    opacity: 1;
    transition: opacity 0.6s;
    margin-bottom: 15px;
}
.closebtn {
    margin-left: 15px;
    color: white;
    font-weight: bold;
    float: right;
    font-size: 22px;
    line-height: 20px;
    cursor: pointer;
    transition: 0.3s;
}

.closebtn:hover {
    color: black;
}
</style>
<body>


	<center>
		<h1>Welcome Admin</h1>
		<a href="studentPersonalDetails.jsp">Add Student+</a><br> <br>
		<a href="index.jsp">Home</a><br> <br>
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
			<td><a href='editStudentDetails.jsp?id=<%=student.getId()%>'>edit</a></td>
			<td><a href='delete?id=<%=student.getId()%>'>delete</a></td>
		</tr>

		<%
			}
		%>

	</table>
	
	
	

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

<script>
var close = document.getElementsByClassName("closebtn");
var i;

for (i = 0; i < close.length; i++) {
    close[i].onclick = function(){
        var div = this.parentElement;
        div.style.opacity = "0";
        setTimeout(function(){ div.style.display = "none"; }, 600);
    }
}
</script>

</body>
</html>