package com.studentwebapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet1")
public class SaveServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String fatherName = request.getParameter("fatherName");
		String motherName = request.getParameter("motherName");
		String gender = request.getParameter("gender");

		out.print("<html><body>");
		out.print("<form action='SaveServlet2' method='post'>");
		out.print("<input type='hidden' name='fatherName' value='" + fatherName + "'>");
		out.print("<input type='hidden' name='motherName' value='" + motherName + "'>");
		out.print("<input type='hidden' name='name' value='" + name + "'>");
		out.print("<input type='hidden' name='email' value='" + email + "'>");

		out.print("<input type='hidden' name='gender' value='" + gender + "'>");
		RequestDispatcher rd = request.getRequestDispatcher("StudentAdd2.html");
		rd.include(request, response);
		out.print("<center><input type='submit' value='submit'></center>");
		out.print("</form>");

		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
