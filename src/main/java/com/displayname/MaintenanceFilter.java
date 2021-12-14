package com.displayname;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*real life example for filters: if our web app is under maintenance, activate a MaintenanceFilter*/


/**
 * Servlet Filter implementation class MaintenanceFilter
 */
public class MaintenanceFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MaintenanceFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("maintenance filter executed");
		
		response.getWriter().write("<html><body><h1>Site under maintenance!!</h1></body></html>");

		// do NOT forward request so the followed filters are not called and thus the request is not forwarded to servlet, either
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
