package com.controller;
import com.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String username=request.getParameter("name");  
	    String password=request.getParameter("password");
	    out.println("<br>");
	    out.println("User name= "+username +"   and password is= "+password );
	    boolean status=StudentDao.isValiduser(username, password);
	   
		if(status==false)
		{
			out.println("<html><body><center><br>---Invalid Login Credentials---</html></body></center>");
			  RequestDispatcher rd=request.getRequestDispatcher("index.html"); 
			  rd.include(request,response); 
		}
		else
			{
				if(username.equals("admin"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("admin.html"); 
					  rd.forward(request,response); 
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("student.html"); 
					  rd.forward(request,response); 		
				}
			}
			
		
		
		
	}

	
	
	
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
