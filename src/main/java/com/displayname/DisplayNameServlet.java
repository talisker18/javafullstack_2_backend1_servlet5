package com.displayname;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayNameServlet
 */
public class DisplayNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fullName = firstName+" "+lastName;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String displayInfo;
		
		if(password.equals("admin")) {
			Cookie fnameCookie = new Cookie("first_name", firstName);
			Cookie lnameCookie = new Cookie("last_name", lastName);
			
			fnameCookie.setMaxAge(12*60*60);
			lnameCookie.setMaxAge(12*60*60);
			
			response.addCookie(fnameCookie); //add to response because server sends the response to client and cookies gonna be saved on client side
			//on the other hand, session info is stored on server side
			response.addCookie(lnameCookie);
			response.setContentType("text/html");
			
			//cookies are saved under: 
			
			displayInfo = "Hello "+fullName+" with email "+email+". Successfully logged in";
		}else {
			displayInfo = "password was wrong";
		}
		
		
		response.getWriter().write("<html><body><h1>"+displayInfo+"</h1></body></html>");
		
		//sample request: http://localhost:8081/javafullstack_2_backend1_servlet5/DisplayNameServlet?firstName=Joel&lastName=Henz
		
		
	}

}
