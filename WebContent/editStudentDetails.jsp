
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    
    import="com.studentwebapplication.model.*"
    import="com.studentwebapplication.serviceimpl.*"
    import="com.studentwebapplication.service.*"
    import="com.studentwebapplication.servicefactory.*"
    
      %>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit details</title>
</head>
<body>    

	<script src="studentDetailsValidation.js"></script>
<%

StudentManagementService studentManagementServic=(StudentManagementService)ObjectFactory.getInstance(StudentManagementServiceImpl.class);
String sid=request.getParameter("id");    
int id = Integer.valueOf(sid);

Student std=studentManagementServic.getStudentById(id);
%>

<%! String message = ""; %> 
     <% message  = (String) request.getAttribute("message"); 
 
    %> 
    <%if(message!=null){
    %>
    <p><%=message %></p>
    <%} %>
  <form action='edit' method='post'>
	        <table>  
    
	        <tr><td></td><td><input type='hidden' name='id' value='<%= std.getId()%>'/></td></tr> 
	        <tr><td>Name:</td><td><input type='text' name='name' value='<%= std.getName()%>'/></td></tr>
	        
	        <tr><td></td><td><input type='hidden' name='originalEmail' value='<%= std.getEmail()%>'/></td></tr>
	        
	          
	        <tr><td>Email:</td><td><input type='email' name='email' value='<%= std.getEmail()%>'/></td></tr> 
	          
	        <tr><td>Father Name:</td><td><input type='text' name='fatherName' value='<%= std.getFatherName()%>'/></td></tr>
	        <tr><td>Mother Name:</td><td><input type='text' name='motherName' value='<%= std.getMothername()%>'/></td></tr>
	        
	        
	        <tr><td>Gender:</td><td><input type='radio' name='gender' value='male' checked/>Male</td></tr>
	        <tr><td></td><td><input type='radio' name='gender' value='female'/>Female</td></tr>
	        <tr><td></td><td><input type='radio' name='gender' value='other'/>Other</td></tr>
	          
	        
	        <tr><td>Class Standard:</td><td><input type='number' name='presentClass' value='<%= std.getPresentClass()%>'/></td></tr> 
	          
	        <tr><td>Marks:</td><td><input type='number' name='marks' value='<%= std.getMarks()%>'/></td></tr>
	          
	        <tr><td>Attendence:</td><td><input type='number' name='attendence' value='<%= std.getAttendence()%>'/></td></tr>  
	        <tr><td>Class Rank:</td><td><input type='number' name='classrank' value='<%= std.getClassrank()%>'/></td></tr>
	        <tr><td>Username:</td><td><input type='text' name='username' value='<%= std.getUsername()%>'/></td></tr> 
	        <tr><td>Password:</td><td><input type='password' name='password' value='<%= std.getPassword()%>'/></td></tr>
	        <tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>
	        
	       
	        </table>  
	        </form> 


</body>
</head>
</html>