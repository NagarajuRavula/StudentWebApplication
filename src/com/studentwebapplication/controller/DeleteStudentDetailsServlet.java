package com.studentwebapplication.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.beanfactory.*;
import com.studentwebapplication.service.DeleteStudentDetailsService;
import com.studentwebapplication.service.impl.DeleteStudentDetailsServiceImpl;
import com.studentwebapplication.utils.ErrorProperties;

@WebServlet("/delete")
public class DeleteStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DeleteStudentDetailsService deleteStudentDetailsService = null;
		deleteStudentDetailsService = (DeleteStudentDetailsService) ObjectFactory
				.getInstance(DeleteStudentDetailsServiceImpl.class);

		String errorMessage = null;
		RequestDispatcher rd = null;
		Properties props = ErrorProperties.getProperty();
		int id = Integer.parseInt(request.getParameter("id"));
		int status = deleteStudentDetailsService.deleteStudent(id);
		if (status > 0) {
			errorMessage = props.getProperty("DELETE_SUCCESS");
			request.setAttribute("deleteMessage", errorMessage);
			rd = request.getRequestDispatcher("./jsp/adminHome.jsp");
		} else {
			errorMessage = props.getProperty("DATABASE_ERROR");
			request.setAttribute("deleteMessage", errorMessage);
			rd = request.getRequestDispatcher(".jsp/adminHome.jsp");
		}

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
