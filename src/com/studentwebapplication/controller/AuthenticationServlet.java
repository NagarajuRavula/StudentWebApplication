package com.studentwebapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.service.StudentManagementService;
import com.studentwebapplication.serviceimpl.StudentManagementServiceImpl;

@WebServlet("/authenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentManagementService studentManagementService = new StudentManagementServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		boolean status = studentManagementService.isValidUser(username, password);

		if (status == false) {
			//out.println("<html><body><center><br>---Invalid Login Credentials---</html></body></center>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		} else {
			if (username.equals("admin")) {
				response.sendRedirect("adminHome.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("studentHome.html");
				rd.forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
