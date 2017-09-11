package com.studentwebapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.daoimpl.*;
import com.studentwebapplication.model.*;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
    SchoolStudentDAO StudentDao=new SchoolStudentDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Student Information</h1>");  
	        String sid=request.getParameter("id");    
	        int id = Integer.valueOf(sid);
	   
	        Student std=StudentDao.getStudentById(id);
	          
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+std.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+std.getName()+"'/></td></tr>");  
	          
	        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+std.getEmail()+"'/></td></tr>");  
	          
	        out.print("<tr><td>Father Name:</td><td><input type='text' name='fatherName' value='"+std.getFatherName()+"'/></td></tr>");  
	        out.print("<tr><td>Mother Name:</td><td><input type='text' name='motherName' value='"+std.getMothername()+"'/></td></tr>");
	        
	        
	        out.print("<tr><td>Gender:</td><td><input type='radio' name='gender' value='male' checked/>Male</td></tr>");  
	        out.print("<tr><td></td><td><input type='radio' name='gender' value='female'/>Female</td></tr>");
	        out.print("<tr><td></td><td><input type='radio' name='gender' value='other'/>Other</td></tr>");
	          
	        
	        out.print("<tr><td>Class Standard:</td><td><input type='number' name='presentClass' value='"+std.getPresentClass()+"'/></td></tr>");  
	          
	        out.print("<tr><td>Marks:</td><td><input type='number' name='marks' value='"+std.getMarks()+"'/></td></tr>");  
	          
	        out.print("<tr><td>Attendence:</td><td><input type='number' name='attendence' value='"+std.getAttendence()+"'/></td></tr>");  
	        out.print("<tr><td>Class Rank:</td><td><input type='number' name='classrank' value='"+std.getClassrank()+"'/></td></tr>");
	        out.print("<tr><td>Username:</td><td><input type='text' name='username' value='"+std.getUsername()+"'/></td></tr>");  
	        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+std.getPassword()+"'/></td></tr>");
	        
	        
	        
	          
	        
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");  
	        
	       
	        out.print("</table>");  
	        out.print("</form>"); 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
