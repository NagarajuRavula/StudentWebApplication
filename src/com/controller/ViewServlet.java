package com.controller;
import com.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
	        out.println("<a href='StudentAdd1.html'>Add New Student</a>");  
	        out.println("<h1>Students List</h1>");  
	          
	        List<Student> list=StudentDao.getAllStudent();
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>Name</th><th>Father Name</th><th>Email</th><th>Gender</th>  "
	                 +"<th>Edit</th><th>Delete</th></tr>");  
	        for(Student std:list){  
	         out.print("<tr><td>"+std.getId()+"</td><td>"+std.getName()+"</td><td>"+std.getFatherName()+"</td>"  
	                 +"<td>"+std.getEmail()+"</td><td>"+std.getGender()+"</td><td><a href='EditServlet?id="+std.getId()+"'>edit</a></td>"  
	                 +"<td><a href='DeleteServlet?id="+std.getId()+"'>delete</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close();  
	    }  
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
