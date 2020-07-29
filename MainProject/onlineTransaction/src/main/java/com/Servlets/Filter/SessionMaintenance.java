package com.Servlets.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "*.bnk")

public class SessionMaintenance implements Filter {

	public void destroy() {
		
	}
 
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		if(request.getSession().getAttribute("userName") != null)
		{
			chain.doFilter(servletRequest,servletResponse);	
		}else {
			request.getRequestDispatcher("/homepage.bank").forward(servletRequest, servletResponse);;
		}

		System.out.println("Requesting Pages :" + request.getRequestURI());
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
