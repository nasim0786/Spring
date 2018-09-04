package com.telusko.web.dao;

import java.sql.*;
import com.telusko.web.model.Alien;

public class AlienDao {
	
	public Alien getAlien(int id) {
		Alien a = new Alien();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nasim","root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from alien where id=" + id);
			
			if(rs.next()) {
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setTech(rs.getString("tech"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return a;
	}

}
