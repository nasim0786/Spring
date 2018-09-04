package com.telusko.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telusko.web.dao.AlienDao;
import com.telusko.web.model.Alien;

public class GetAlienController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		AlienDao dao = new AlienDao();
		Alien a1 = dao.getAlien(id);
		
		request.setAttribute("alien", a1);
		RequestDispatcher rd = request.getRequestDispatcher("showAlien.jsp");
		rd.forward(request, response);
	}


}
