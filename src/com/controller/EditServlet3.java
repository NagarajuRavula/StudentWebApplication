package com.controller;
import com.model.*;
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
 * Servlet implementation class EditServlet3
 */
@WebServlet("/EditServlet3")
public class EditServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet3() {
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
	        String presentClass=request.getParameter("presentClass");   
	        String marks=request.getParameter("marks"); 
	        String attendence=request.getParameter("attendence"); 
	        String classrank=request.getParameter("classrank"); 
	        String username=request.getParameter("username"); 
	        String password=request.getParameter("password");
	        
	     
//		    out.print("<br>"+id);
//		    out.print("<br>"+name);
//		    out.print("<br>"+email);
//		    out.print("<br>"+motherName);
//		    out.print("<br>"+fatherName);
//		    out.print("<br>"+gender);
//		    out.print("<br>"+presentClass);
//		    out.print("<br>"+marks);
//		    out.print("<br>"+attendence);
//		    out.print("<br>"+classrank);
//		    out.print("<br>"+username);
//		    out.print("<br>"+password);
	        
	        int presentclass = Integer.valueOf(presentClass);
		    double MarkS = Double.valueOf(marks);
		    double attendEnce = Double.valueOf(attendence);
		    int classRank = Integer.valueOf(classrank);
		    System.out.println(presentClass);
		    Student std=new Student();
		    std.setName(name);
		    std.setEmail(email);
		    std.setFatherName(fatherName);
		    std.setMothername(motherName);
		    std.setGender(gender);
		    std.setPresentClass(presentclass);
		    std.setMarks(MarkS);
		    std.setAttendence(attendEnce);
		    std.setClassrank(classRank);
		    std.setUsername(username);
		    std.setPassword(password);
//		    out.println("going to update");  
	        
	        int status=StudentDao.update(std);  
	        if(status>0){  
	            response.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        
	      
	        
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
