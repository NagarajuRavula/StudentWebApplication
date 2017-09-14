package com.studentwebapplication.controller;

import java.io.IOException;
import com.studentwebapplication.servicefactory.*;
import com.studentwebapplication.serviceimpl.EditStudentDetailsServiceImpl;
import com.studentwebapplication.serviceimpl.SaveStudentDetailsServiceImpl;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.SaveStudentDetailsService;

@WebServlet("/save")
public class SaveStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SaveStudentDetailsService saveStudentDetailsService =(SaveStudentDetailsService)ObjectFactory.getInstance(SaveStudentDetailsServiceImpl.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String fatherName = request.getParameter("fatherName");
		String classrank = request.getParameter("classrank");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String motherName = request.getParameter("motherName");
		String gender = request.getParameter("gender");
		String presentclass = request.getParameter("presentclass");
		String marks = request.getParameter("marks");
		String attendence = request.getParameter("attendence");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int presentClass = Integer.valueOf(presentclass);
		double MarkS = Double.valueOf(marks);
		double attendEnce = Double.valueOf(attendence);
		int classRank = Integer.valueOf(classrank);
		Student std = new Student();
		std.setName(name);
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
		int status = saveStudentDetailsService.saveStudent(std);
		if (status > 0) {
			response.sendRedirect("adminHome.jsp");
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
