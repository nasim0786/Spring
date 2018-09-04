package com.telusko.web.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telusko.web.dao.LoginDao;

public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		
		if (dao.checkCredentials(username, password))  {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
