package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.model.StudentDao;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("id");   
	        int id = Integer.valueOf(sid);
	        String name=request.getParameter("name");   
	        String email=request.getParameter("email"); 
	        String fatherName=request.getParameter("fatherName"); 
	        String motherName=request.getParameter("motherName"); 
	        String gender=request.getParameter("gender"); 
	        
	        Student std=StudentDao.getStudentById(id);
//		    out.print("<h1>hii</h1>");
//		    out.print("<br>"+name);
//		    out.print("<br>"+email);
//		    out.print("<br>"+motherName);
//		    out.print("<br>"+fatherName);
	//	    out.print("<br>"+gender);
	        out.print("<form action='EditServlet3' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+std.getId()+"'/></td></tr>");  
	        out.print("<tr><td></td><td><input type='hidden' name='name' value='"+std.getName()+"'/></td></tr>");  
	        out.print("<tr><td></td><td><input type='hidden' name='email' value='"+std.getEmail()+"'/></td></tr>");  
	        out.print("<tr><td></td><td><input type='hidden' name='fatherName' value='"+std.getFatherName()+"'/></td></tr>");  
	        out.print("<tr><td></td><td><input type='hidden' name='motherName' value='"+std.getMothername()+"'/></td></tr>");  
	        out.print("<tr><td></td><td><input type='hidden' name='gender' value='"+std.getGender()+"'/></td></tr>");  
	        
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
