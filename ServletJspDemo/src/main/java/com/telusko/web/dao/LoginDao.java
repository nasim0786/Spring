package com.telusko.web.dao;

import java.sql.*;

public class LoginDao {
	
	public boolean checkCredentials(String username, String password) {
		try {
			String query = "select * from login where username=? and password=?";
			String url = "jdbc:mysql://localhost:3306/nasim";
			String uname = "root";
			String passwd = "root";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, passwd);
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, username);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}

}
