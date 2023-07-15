package com.edit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.welcome.dao.DatabaseReader;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		
		
		DatabaseReader dr = new DatabaseReader();
		String[] data = dr.getDataByTitle(title);
		 request.setAttribute("data", data);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
	        dispatcher.forward(request, response);
	        }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
	        String title = request.getParameter("title");
	        String quantity = request.getParameter("quantity");
	        String size = request.getParameter("size");
	        String image = request.getParameter("image");

	        // Update the data in the database
	        DatabaseReader dr = new DatabaseReader();
	        boolean success = dr.updateData(title, quantity, size, image); // Implement a method in DatabaseUpdater to update the data
	        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
	        dispatcher.forward(request, response);

	        if (success) {
	        	PrintWriter out = response.getWriter();
	            out.println("edit success");
	        } else {
	            // Handle error
	        }
	    }
}
