package com.controller;
import com.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
	        out.println("<h1>Update Student Information</h1>");  
	        String sid=request.getParameter("id");    
	        int id = Integer.valueOf(sid);
	   
	        Student std=StudentDao.getStudentById(id);
	          
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+std.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+std.getName()+"'/></td></tr>");  
	          
	        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+std.getEmail()+"'/></td></tr>");  
	          
	        out.print("<tr><td>Father Name:</td><td><input type='email' name='fatherName' value='"+std.getFatherName()+"'/></td></tr>");  
	        out.print("<tr><td>Mother Name:</td><td><input type='email' name='motherName' value='"+std.getMothername()+"'/></td></tr>");
	        
	        
	        out.print("<tr><td>Gender:</td><td><input type='radio' name='gender' value='male' checked/>Male</td></tr>");  
	        out.print("<tr><td></td><td><input type='radio' name='gender' value='female'/>Female</td></tr>");
	        out.print("<tr><td></td><td><input type='radio' name='gender' value='other'/>Other</td></tr>");
	          
	        
	        out.print("<tr><td colspan='2'><input type='submit' value='Next '/></td></tr>");  
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
