
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studentwebapplication.model.*"
	import="com.studentwebapplication.serviceimpl.*"
	import="com.studentwebapplication.service.*"
	import="com.studentwebapplication.servicefactory.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit details</title>

<link rel="stylesheet"
	href=${pageContext.request.contextPath}/style/editStudentDetails.css>
</head>
<body>

	<script src=${pageContext.request.contextPath}/js/studentDetailsValidation.js></script>
	
	
	
	<%

StudentManagementService studentManagementServic=(StudentManagementService)ObjectFactory.getInstance(StudentManagementServiceImpl.class);
String sid=request.getParameter("id");    
int id = Integer.valueOf(sid);

Student std=studentManagementServic.getStudentById(id);
%>
<center>
<div class="header">
		<h2 >Student Management Application</h2>

	</div>

	<%! String message = "";
	%>
	<% message  = (String) request.getAttribute("message"); 
 
    %>
	<%if(message!=null){
    %>
	<p><%=message %></p>
	<%
	} %>




<button id="editButton" onclick="enableFileds()" >Edit Details</button>
<div class="container">  
  <form id="contact" action=${pageContext.request.contextPath}/edit method="post">
    <h3>Student Details</h3>
    <h4>click on Edit button to change details</h4>
    <fieldset id="formFields" disabled>
    <fieldset>
     <input  type="hidden" id="id" name="id" value='<%= std.getId()%>'>
    </fieldset>
    <fieldset>
     <input type="text" name="name" id="name" tabindex="1" value='<%= std.getName()%>' data-tooltip aria-haspopup="true" title="Student Name" required>
    </fieldset>
    <fieldset>
     <input  type="email" id="email" name="email" tabindex="2" value='<%= std.getEmail()%>' data-tooltip aria-haspopup="true" title="Student Email"  required>
    </fieldset>
    <fieldset>
     <input  type="hidden" id="'originalEmail'" name="originalEmail" value='<%= std.getEmail()%>' required>
    </fieldset>
    <fieldset>
      <input type="text" tabindex="3" id="fatherName" name="fatherName" value='<%= std.getFatherName()%>' data-tooltip aria-haspopup="true" title="Student Father Name"  required>
    </fieldset>
    <fieldset>
      <input  type="text" tabindex="4" id="motherName" name="motherName" value='<%= std.getMothername()%>' data-tooltip aria-haspopup="true" title="Student Mother Name"  required>
    </fieldset>
    <fieldset>
      <select   name="gender" id="gender" data-tooltip aria-haspopup="true" title="Student Gender" >
      <option>Gender</option>
       <option>Male</option>
       <option>Female</option>
       <option>Other</option>
       </select>
    </fieldset>
    
     <fieldset>
      <input type="number" name="presentClass" id="presentClass" min=1 max=10  tabindex="6" value='<%= std.getPresentClass()%>' data-tooltip aria-haspopup="true" title="Student Present Class" required>
    </fieldset>
    <fieldset>
      <input type="number"  name="marks" id="marks" tabindex="7" min=1 max=600 value='<%= std.getMarks()%>' data-tooltip aria-haspopup="true" title="Student Marks" required>
    </fieldset>
    <fieldset>
      <input  type="number" tabindex="8"  min=1 max=100 name="attendence" id="attendence"  value='<%= std.getAttendence()%>' data-tooltip aria-haspopup="true" title="Student Attendence"  required>
    </fieldset>
    <fieldset>
      <input type="number" tabindex="9" name="classrank" id="classrank" value='<%= std.getClassrank()%>' data-tooltip aria-haspopup="true" title="Student Class Rank"  required >
    </fieldset>
    <fieldset>
      <input  type="password" tabindex="10" name="password" id="password" value='<%= std.getPassword()%>' data-tooltip aria-haspopup="true" title="Student Login Password"  required>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="educational-submit" >Update details</button>
    </fieldset>
    
    </fieldset>
  </form>
</div>


</center>
</body>
</head>
</html>