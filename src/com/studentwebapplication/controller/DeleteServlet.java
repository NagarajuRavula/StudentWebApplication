package com.studentwebapplication.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.daoimpl.*;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	SchoolStudentDAO StudentDao=new SchoolStudentDAO();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		 String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        StudentDao.delete(id);  
	        response.sendRedirect("adminHome.jsp");  

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
