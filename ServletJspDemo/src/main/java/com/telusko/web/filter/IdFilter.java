package com.telusko.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebServlet("/addFilter")
public class IdFilter implements javax.servlet.Filter {
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		
		if(id > 0)
		chain.doFilter(request, response);
		else
			out.println("Invalid Input");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
