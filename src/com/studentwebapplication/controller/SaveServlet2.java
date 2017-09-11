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


@WebServlet("/SaveServlet2")
public class SaveServlet2 extends HttpServlet {
	
	    SchoolStudentDAO StudentDao=new SchoolStudentDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
		
		 String fatherName=request.getParameter("fatherName");
		 String classrank=request.getParameter("classrank");
		// int classrank=Integer.parseInt(classRank); 
		 String name=request.getParameter("name");
		 String email=request.getParameter("email");
		 String motherName=request.getParameter("motherName");
		// String dob=request.getParameter("dob");
		 String gender=request.getParameter("gender");
		 String presentclass=request.getParameter("presentclass");
		// int presentclass=Integer.parseInt(presentClass); 
		 String marks=request.getParameter("marks");
		 //Double marks=Double.parseDouble(markS); 
		 String attendence=request.getParameter("attendence");
		// Double attendence=Double.parseDouble(attenDence);
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
//		 out.print("<br>"+name);
//		    out.print("<br>"+email);
//		    out.print("<br>"+fatherName);
//		    out.print("<br>"+motherName);
//		    //out.print("<br>"+dob);
//		    out.print("<br>"+gender);
//		    out.print("<br>"+presentclass);
//		    out.print("<br>"+marks);
//		    out.print("<br>"+attendence);
//		    out.print("<br>"+classrank);
//		    out.print("<br>"+username);
//		    out.print("<br>"+password);
		    
		    int presentClass = Integer.valueOf(presentclass);
		    double MarkS = Double.valueOf(marks);
		    double attendEnce = Double.valueOf(attendence);
		    int classRank = Integer.valueOf(classrank);
		    Student std=new Student();
		    std.setName(username);
		    std.setEmail(email);
		    std.setFatherName(fatherName);
		    std.setMothername(motherName);
		    std.setGender(gender);
		    std.setPresentClass(presentClass);
		    std.setMarks(MarkS);
		    std.setAttendence(attendEnce);
		    std.setClassrank(classRank);
		    std.setUsername(username);
		    std.setPassword(password);
		    int status=StudentDao.save(std);
		    if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	          //  request.getRequestDispatcher("index.html").include(request, response);  
	            response.sendRedirect("adminHome.jsp"); 
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
		    
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
