package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SquareServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		/*HttpSession session = req.getSession();
		
		int k = (int) session.getAttribute("k");*/
		int k = 0;
		Cookie cookies[] = req.getCookies();
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("k"))
				k = Integer.parseInt(cookie.getValue());
		}
		
		
		
		k = k * k;
		PrintWriter  out = res.getWriter();
		
		out.println("Hello sq: " + k);
	}

}
