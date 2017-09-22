<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.studentwebapplication.beanfactory.*"
	import="com.studentwebapplication.service.impl.*"
	import="com.studentwebapplication.service.*"
	import="java.io.FileInputStream" import="java.io.IOException"
	import="java.util.Properties"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Education Details</title>
</head>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/style/studentEducationDetails.css>
<body>
	<%!String message=""; %>
	<%
		StudentManagementService studentManagementService = (StudentManagementService) ObjectFactory
				.getInstance(StudentManagementServiceImpl.class);
	Properties props = (Properties)ObjectFactory.getInstance(Properties.class);
	FileInputStream fis = null;
	try{
		fis = new FileInputStream("/home/nagarajur/workspace/StudentWebApplication/src/resources/errorMessage.properties");
		props.load(fis);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	
	
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		 boolean status=studentManagementService.isExistingStudent(email);
		 if (status==true) {
			 message=email+" "+props.getProperty("EXISTING_USER");
		
			request.setAttribute("message",message );
			
			RequestDispatcher rd = request.getRequestDispatcher("studentPersonalDetails.jsp");
			rd.forward(request, response);
		 }
		String fatherName = request.getParameter("fatherName");
		String motherName = request.getParameter("motherName");
		String gender = request.getParameter("gender");
	%>

<html>
<body>
	<center>
<!-- 		<div> -->
<!-- 			<form action='../save' method='post'> -->
<%-- 				<input type='hidden' name='fatherName' value='<%=fatherName%>'> --%>
<%-- 				<input type='hidden' name='motherName' value='<%=motherName%>'> --%>
<%-- 				<input type='hidden' name='name' value='<%=name%>'> <input --%>
<%-- 					type='hidden' name='email' value='<%=email%>'> <input --%>
<%-- 					type='hidden' name='gender' value='<%=gender%>'> --%>
<!-- 				<h1>Enter Educational Data.</h1> -->
<!-- 				<br> -->
<!-- 				<table> -->
<!-- 					<tr> -->
<!-- 						<td>class Standard:</td> -->
<!-- 						<td><input type="number" name="presentclass" min=1 max=10></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>Marks:</td> -->
<!-- 						<td><input type="number" name="marks"></td> -->
<!-- 					<tr> -->
<!-- 					<tr> -->
<!-- 						<td>Attendence Percentage:</td> -->
<!-- 						<td><input type="number" name="attendence"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>Class Rank: -->
<!-- 						<td><input type="number" name="classrank"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td><p>Enter the Student Login Password#</p></td> -->
<!-- 						<td></td> -->
<!-- 					</tr> -->

<!-- 					<tr> -->
<!-- 						<td>Password:</td> -->
<!-- 						<td><input type="password" name="password"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td></td> -->
<!-- 						<td><input type='submit' value='submit'></td> -->
<!-- 					</tr> -->

<!-- 				</table> -->
<!-- 			</form> -->
<!-- 		</div> -->

<div class="header">
		<h2 >Student Management Application</h2>

	</div>
<div class="container">  
  <form id="contact" action=${pageContext.request.contextPath}/save method="post">
    <h3>Student registration form</h3>
    <h4>Enter the student Educational data</h4>
    
    
    <input type='hidden' name='fatherName' value='<%=fatherName%>'> 
 	<input type='hidden' name='motherName' value='<%=motherName%>'> 
 	<input type='hidden' name='name' value='<%=name%>'> 
 	<input type='hidden' name='email' value='<%=email%>'>
 	<input  type='hidden' name='gender' value='<%=gender%>'>
    
    
    <fieldset>
      <input placeholder="Class Standard" type="number" name="presentclass" min=1 max=10 autofocus tabindex="1" required>
    </fieldset>
    <fieldset>
      <input placeholder="Marks" type="number"  name="marks" tabindex="2" min=1 max=600 required>
    </fieldset>
    <fieldset>
      <input placeholder="Attendence Percentage" type="number" tabindex="3"  min=1 max=100 name="attendence" required>
    </fieldset>
    <fieldset>
      <input placeholder="Class Rank" type="number" tabindex="4" name="classrank" required>
    </fieldset>
    <fieldset>
      <input placeholder="Enter Student Login Password" type="password" tabindex="5" name="password" required>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="educational-submit" >Register</button>
    </fieldset>
  </form>
</div>



	</center>

</body>
</html>