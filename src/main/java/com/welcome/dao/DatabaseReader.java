package com.welcome.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

	public class DatabaseReader {
	    private static final String DB_URL = "jdbc:mysql://localhost:3306/assignment06";
	    private static final String USER = "root";
	    private static final String PASS = "root";

	    public static List<String[]> readDataFromTable() {
	        List<String[]> dataList = new ArrayList<>();
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM data")) {

	            while(rs.next()) {
	                String[] rowData = new String[4]; // assuming 4 fields in table
	                rowData[0] = rs.getString(1); // assuming first field is of string type
	                rowData[1] = rs.getString(2); // assuming second field is of string type
	                rowData[2] = rs.getString(3); // assuming third field is of string type
	                rowData[3] = rs.getString(4); // assuming fourth field is of string type
	                dataList.add(rowData);
	            }
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return dataList;
	    }
	    
	    
	    
	    public  String[] getDataByTitle(String title) {
	    	String[] data = new String[4];

	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM data WHERE title = ?")) {
	            stmt.setString(1, title);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	           
	                data[0] = rs.getString("title");
	                data[1] = rs.getString("quantity");
	                data[2] = rs.getString("size");
	                data[3] = rs.getString("image");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return data;
	    }
	    public boolean updateData( String title, String quantity, String size, String image) {
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             PreparedStatement stmt = conn.prepareStatement("UPDATE data SET title=?, quantity=?, size=?, image=? WHERE title=?")) {
	            stmt.setString(1, title);
	            stmt.setString(2, quantity);
	            stmt.setString(3, size);
	            stmt.setString(4, image);
	            stmt.setString(5, title);
	         

	            int rowsAffected = stmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }
	    


	}

