package com.displayname;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    //called before the filter instance is removed from the service by the web container (tomcat)
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String ipAdress = request.getRemoteAddr(); //read ip address of client machine
		
		//log the ip address and current timestamp
		System.out.println("IP: "+ipAdress+", timestamp: "+ new Date().toString());
		chain.doFilter(request, response); //to go to index.html, do the chain.doFilter(). This happens because we do not have defined an URL for LogFilter (url pattern /*), so its jumps automatically to index.html
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	//init method is executed only once when application is started. when application starts, all filters are loaded into memory -> thats done by this init method
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		//get the init param defined in web.xml
		String logFilterParam = fConfig.getInitParameter("logFilterParam");
		System.out.println("LogFilter will be initialised with param: "+logFilterParam);
	}

}
