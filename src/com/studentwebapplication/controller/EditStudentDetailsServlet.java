package com.studentwebapplication.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentwebapplication.beanfactory.*;
import com.studentwebapplication.model.*;
import com.studentwebapplication.service.EditStudentDetailsService;
import com.studentwebapplication.service.StudentManagementService;
import com.studentwebapplication.service.impl.EditStudentDetailsServiceImpl;
import com.studentwebapplication.service.impl.StudentManagementServiceImpl;
import com.studentwebapplication.utils.ErrorProperties;

@WebServlet("/edit")
public class EditStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EditStudentDetailsService editStudentDetailsService = (EditStudentDetailsService) ObjectFactory
				.getInstance(EditStudentDetailsServiceImpl.class);
		StudentManagementService studentManagementService = (StudentManagementService) ObjectFactory
				.getInstance(StudentManagementServiceImpl.class);
		String errorMessage;
		RequestDispatcher rd = null;
		HttpSession session=request.getSession();
		String logedInUser=(String)session.getAttribute("logedInUser");
		Properties props = ErrorProperties.getProperty();
		int id = Integer.valueOf(request.getParameter("id"));
		String originalEmail = request.getParameter("originalEmail");
		String email = request.getParameter("email");
		if (!email.equals(originalEmail)) {

			boolean status = studentManagementService.isExistingStudent(email);
			if (status) {

				errorMessage = email + "  " + props.getProperty("EXISTING_USER");
				request.setAttribute("id", id);
				request.setAttribute("message", errorMessage);
				rd = request.getRequestDispatcher("./jsp/editStudentDetails.jsp");
				rd.forward(request, response);
				return;
			}
		}
		Student std = (Student) ObjectFactory.getInstance(Student.class);
		std.setId(id);
		std.setName(request.getParameter("name"));
		std.setEmail(email);
		std.setFatherName(request.getParameter("fatherName"));
		std.setMothername(request.getParameter("motherName"));
		std.setGender(request.getParameter("gender"));
		std.setPresentClass(Integer.valueOf(request.getParameter("presentClass")));
		std.setMarks(Double.valueOf(request.getParameter("marks")));
		std.setAttendence(Double.valueOf(request.getParameter("attendence")));
		std.setClassrank(Integer.valueOf(request.getParameter("classrank")));
		std.setPassword(request.getParameter("password"));
		int status = editStudentDetailsService.updateStudent(std);
		if (status > 0) {
			if(logedInUser.equals("admin@gmail.com")){
			rd = request.getRequestDispatcher("./jsp/adminHome.jsp");}
			else{
				rd = request.getRequestDispatcher("./jsp/studentHome.jsp");}

		} else {
			errorMessage = props.getProperty("DATABASE_ERROR");
			request.setAttribute("message", errorMessage);
			request.setAttribute("id", id);
			rd = request.getRequestDispatcher("./jsp/editStudentDetails.jsp");
		}
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
