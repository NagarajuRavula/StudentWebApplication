package com.studentwebapplication.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Properties props = (Properties) ObjectFactory.getInstance(Properties.class);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					"/home/nagarajur/workspace/StudentWebApplication/src/resources/errorMessage.properties");
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();

		}

		final String USERNAME = request.getParameter("email");
		final String PASSWORD = request.getParameter("password");
		StudentManagementService studentManagementService = null;

		String message;
		RequestDispatcher rd = null;

		studentManagementService = (StudentManagementService) ObjectFactory
				.getInstance(StudentManagementServiceImpl.class);

		boolean status = studentManagementService.authenticateUser(USERNAME, PASSWORD);

		if (!status) {
			message = props.getProperty("INVALID_CREDENTIALS");
			request.setAttribute("message", message);
			rd = request.getRequestDispatcher("./jsp/login.jsp");
		} else {
			if (USERNAME.equals("admin@gmail.com")) {
				rd = request.getRequestDispatcher("./jsp/adminHome.jsp");
			} else {
				rd = request.getRequestDispatcher("./jsp/studentHome.jsp");
			}
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
