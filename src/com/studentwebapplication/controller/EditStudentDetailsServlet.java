package com.studentwebapplication.controller;

import java.io.IOException;
import com.studentwebapplication.servicefactory.*;
import com.studentwebapplication.serviceimpl.EditStudentDetailsServiceImpl;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.studentwebapplication.model.*;
import com.studentwebapplication.service.EditStudentDetailsService;
@WebServlet("/edit")
public class EditStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//EditStudentDetailsService editStudentDetailsService=new EditStudentDetailsServiceImpl();
	EditStudentDetailsService editStudentDetailsService=(EditStudentDetailsService)ObjectFactory.getInstance(EditStudentDetailsServiceImpl.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
         
        int presentclass = Integer.valueOf(presentClass);
	    double MarkS = Double.valueOf(marks);
	    double attendEnce = Double.valueOf(attendence);
	    int classRank = Integer.valueOf(classrank);
	    Student std=new Student();
	    std.setId(id);
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
        int status=editStudentDetailsService.updateStudent(std) ;
        if(status>0){  
            response.sendRedirect("adminHome.jsp");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
		
		
		
	}


	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
