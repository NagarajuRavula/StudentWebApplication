<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.studentwebapplication.model.*"
import ="com.studentwebapplication.daoimpl.*"
   import ="java.util.List "
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>Welcome Admin</h1>
<a href="StudentAdd1.html">Add Student+</a><br><br>
<h3>Students List</h3>
</center>

<%   
  SchoolStudentDAO StudentDao=new SchoolStudentDAO();

 List<Student> list=StudentDao.getAllStudents();
  
out.print("<table border='1' width='100%'");  
out.print("<tr><th>Id</th><th>Name</th><th>Father Name</th><th>Email</th><th>Gender</th>  "
         +"<th>Edit</th><th>Delete</th></tr>");  
for(Student std:list){  
 out.print("<tr><td>"+std.getId()+"</td><td>"+std.getName()+"</td><td>"+std.getFatherName()+"</td>"  
         +"<td>"+std.getEmail()+"</td><td>"+std.getGender()+"</td><td><a href='EditServlet?id="+std.getId()+"'>edit</a></td>"  
         +"<td><a href='DeleteServlet?id="+std.getId()+"'>delete</a></td></tr>");  
}  
out.print("</table>"); 



%>


</body>
</html>