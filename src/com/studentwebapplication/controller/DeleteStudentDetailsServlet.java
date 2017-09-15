package com.studentwebapplication.controller;

import java.io.FileInputStream;
import java.io.IOException;
import com.studentwebapplication.servicefactory.*;
import com.studentwebapplication.serviceimpl.DeleteStudentDetailsServiceImpl;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentwebapplication.service.DeleteStudentDetailsService;

@WebServlet("/delete")
public class DeleteStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DeleteStudentDetailsService deleteStudentDetailsService = null;
		deleteStudentDetailsService = (DeleteStudentDetailsService) ObjectFactory
				.getInstance(DeleteStudentDetailsServiceImpl.class);

		String message = null;
		RequestDispatcher rd = null;
		Properties props = (Properties) ObjectFactory.getInstance(Properties.class);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					"/home/nagarajur/workspace/StudentWebApplication/src/resources/errorMessage.properties");
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();

		}
		int id = Integer.parseInt(request.getParameter("id"));
		int status = deleteStudentDetailsService.deleteStudent(id);
		if (status > 0) {
			message = props.getProperty("DELETE_SUCCESS");
			request.setAttribute("deleteMessage", message);
			rd = request.getRequestDispatcher("adminHome.jsp");
		} else {
			message = props.getProperty("DATABASE_ERROR");
			request.setAttribute("deleteMessage", message);
			rd = request.getRequestDispatcher("adminHome.jsp");
		}

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
