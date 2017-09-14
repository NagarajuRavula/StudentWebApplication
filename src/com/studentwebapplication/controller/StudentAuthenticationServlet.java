package com.studentwebapplication.controller;

import java.io.IOException;
import com.studentwebapplication.servicefactory.*;
import com.studentwebapplication.serviceimpl.StudentManagementServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentwebapplication.service.StudentManagementService;

@WebServlet("/authentication")
public class StudentAuthenticationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private StudentManagementService studentManagementService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 final String USERNAME = request.getParameter("name");
		 final String PASSWORD = request.getParameter("password");
		 String message;
		
		
		studentManagementService = (StudentManagementService) ObjectFactory.getInstance(StudentManagementServiceImpl.class);
		
		boolean status = studentManagementService.isValidUser( USERNAME, PASSWORD);
            
		request.setAttribute("status",status);
		if (status == false) {
			 message="---Invalid Login Credentials---";
		
			request.setAttribute("message",message );
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		} else {
			message="---Login Successful----";
			request.setAttribute("message",message );
			if (USERNAME.equals("admin")) {
				response.sendRedirect("adminHome.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("studentHome.jsp");
				rd.forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
