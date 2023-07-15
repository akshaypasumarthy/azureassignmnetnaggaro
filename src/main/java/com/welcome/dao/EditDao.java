package com.welcome.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditDao {


	String url = "jdbc:mysql://localhost:3306/assignment06";
	String user="root";
	String password="root";
	String sql = "UPDATE DATA SET  quantity=?, size=?, image=?  WHERE title=? ";


	
	public boolean check(String title,String quantity,String size, String image) throws SQLException {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement st= (PreparedStatement) con.prepareStatement(sql);
		st.setString(1,title);
		st.setString(2,quantity);
		st.setString(3,size);
		st.setString(4,image);
		int rowseffected=st.executeUpdate();
		if(rowseffected>0) {
		return true;
			}
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		return false;
	
	}
}
