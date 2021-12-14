package com.displayname;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTrackingServlet
 */
public class SessionTrackingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTrackingServlet() {
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
		/*description from apache doc
		 * 
		 * The servlet container creates an HttpServletRequest object and passes it as an argument to the servlet's service methods (doGet, doPost, etc). 
		 * 
		 * 
		 * 
		 * --> see notes_with pics.word how a webserver keeps tracking of an user
		 * 
		 * --> To track sessions, a web session ID is stored in a visitor’s browser. 
		 * This session ID is passed along with any HTTP requests that the visitor makes while on the site (e.g., clicking a link)!!!!
		 * */
		
		
		System.out.println(request.getSession().getId()); //a session is saved in HttpServletRequest object on server side!!!
		HttpSession session = request.getSession(); //if a user requests this servlet for first time, a new session is created. for any further visits, the created session is given back
		
		Date firstAccessTime = new Date(session.getCreationTime());
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		String visitCountKey = "numberOfVisits";
		Integer visitCount = 0;
		
		if(!session.isNew()) { //if website is visited first time by a user, this block is not executed
			visitCount = (Integer) session.getAttribute(visitCountKey);
			visitCount++;
		}
		
		session.setAttribute(visitCountKey, visitCount);
		
		PrintWriter out = response.getWriter();
		
		out.write("<html><body><h2>session info</h2>");
		
		out.write("<h3>session id: "+session.getId()+"</h3>");
		out.write("<h3>session creation: "+firstAccessTime+"</h3>");
		out.write("<h3>last accessed: "+lastAccessTime+"</h3>");
		out.write("<h3>visitors: "+visitCount+"</h3>");
		
		out.write("</body></html>");
		
	}

}
