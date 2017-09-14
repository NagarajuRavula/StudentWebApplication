package com.studentwebapplication.controller;

import java.io.IOException;
import com.studentwebapplication.servicefactory.*;
import com.studentwebapplication.serviceimpl.DeleteStudentDetailsServiceImpl;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.service.DeleteStudentDetailsService;

@WebServlet("/delete")
public class DeleteStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeleteStudentDetailsService deleteStudentDetailsService = (DeleteStudentDetailsService) ObjectFactory
			.getInstance(DeleteStudentDetailsServiceImpl.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		int status = deleteStudentDetailsService.deleteStudent(id);
		if (status > 0)
			response.sendRedirect("adminHome.jsp");
		else {
			out.println("Sorry! unable to delete record");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
