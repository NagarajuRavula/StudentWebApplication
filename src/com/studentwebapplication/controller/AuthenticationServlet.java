package com.studentwebapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.daoimpl.*;
import com.studentwebapplication.model.*;

@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {

	SchoolStudentDAO StudentDao = new SchoolStudentDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		boolean status = StudentDao.isValidStudent(username, password);

		if (status == false) {
			out.println("<html><body><center><br>---Invalid Login Credentials---</html></body></center>");
		//	response.sendRedirect("index.html");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		} else {
			if (username.equals("admin")) {
				response.sendRedirect("adminHome.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("student.html");
				rd.forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
