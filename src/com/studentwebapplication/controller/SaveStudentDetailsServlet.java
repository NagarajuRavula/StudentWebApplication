package com.studentwebapplication.controller;

import java.io.FileInputStream;
import java.io.IOException;
import com.studentwebapplication.servicefactory.*;
import com.studentwebapplication.serviceimpl.SaveStudentDetailsServiceImpl;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SaveStudentDetailsService saveStudentDetailsService = (SaveStudentDetailsService) ObjectFactory
				.getInstance(SaveStudentDetailsServiceImpl.class);

		String message=null;
		Properties props = (Properties) ObjectFactory.getInstance(Properties.class);
		FileInputStream fis = null;
		RequestDispatcher rd = null;
		try {
			fis = new FileInputStream(
					"/home/nagarajur/workspace/StudentWebApplication/src/resources/errorMessage.properties");
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Student std = (Student) ObjectFactory.getInstance(Student.class);
		std.setName(request.getParameter("name"));
		std.setEmail(request.getParameter("email"));
		std.setFatherName(request.getParameter("fatherName"));
		std.setMothername(request.getParameter("motherName"));
		std.setGender(request.getParameter("gender"));
		std.setPresentClass(Integer.valueOf(request.getParameter("presentclass")));
		std.setMarks(Double.valueOf(request.getParameter("marks")));
		std.setAttendence(Double.valueOf(request.getParameter("attendence")));
		std.setClassrank(Integer.valueOf(request.getParameter("classrank")));
		std.setPassword(request.getParameter("password"));
		int status = saveStudentDetailsService.saveStudent(std);
		if (status > 0) {
			rd = request.getRequestDispatcher("adminHome.jsp");
		} else {
			message = props.getProperty("DATABASE_ERROR");
			request.setAttribute("message", message);
			rd = request.getRequestDispatcher("studentPersonalDetails.jsp");

		}
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
