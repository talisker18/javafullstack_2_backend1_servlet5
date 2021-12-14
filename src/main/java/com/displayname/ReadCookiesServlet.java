package com.displayname;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookiesServlet
 */
public class ReadCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		Cookie[] cookies = null;
		
		cookies = request.getCookies(); //since cookies are saved on client side, we will access the cookies by the HttpServletRequest, not the response!!
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.write("<html><body><h2>cookies</h2>");
		
		if(cookies != null) {
			out.write("<h2>found cookies</h2>");
			
			for(Cookie c: cookies) {
				out.write(c.getName()+" : ");
				out.write(c.getValue()+"<br>");
			}
		}else {
			out.write("<h2>no cookies found</h2>");
		}
		
		out.write("</body></html>");
	}

}
