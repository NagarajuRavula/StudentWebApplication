package com.studentwebapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.service.StudentManagementService;
import com.studentwebapplication.servicefactory.ObjectFactory;
import com.studentwebapplication.serviceimpl.StudentManagementServiceImpl;

@WebServlet("/authentication")
public class StudentAuthenticationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentManagementService studentManagementService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String USERNAME = request.getParameter("name");
		final String PASSWORD = request.getParameter("password");
		
		String message;
		RequestDispatcher rd = null;

		studentManagementService = (StudentManagementService) ObjectFactory
				.getInstance(StudentManagementServiceImpl.class);

		boolean status = studentManagementService.authenticateUser(USERNAME, PASSWORD);

		if (!status) {
			message = "---Invalid Login Credentials---";
			request.setAttribute("message", message);
			rd = request.getRequestDispatcher("index.jsp");
		} else {
			if (USERNAME.equals("nagaraju321@gmail.com")) {
				rd = request.getRequestDispatcher("adminHome.jsp");
			} else {
				rd = request.getRequestDispatcher("studentHome.jsp");
			}
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
