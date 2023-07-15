package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class LoginDao {

	String sql="select * from login where username=? and password=?";
	String url="jdbc:mysql://localhost:3306/assignment06";
	String username1="root";
	String password1="root";
	public boolean check(String uname,String password) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username1,password1);
			PreparedStatement st= (PreparedStatement) con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}
}
