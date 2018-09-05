package com.luv2code.jdbc;

import java.sql.*;

public class TestJdbc {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false","hbstudent","hbstudent");
			//Statement st = con.createStatement();
			//ResultSet rs = st.executeQuery("select * from student");
			
			System.out.println("Connection Successful");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
