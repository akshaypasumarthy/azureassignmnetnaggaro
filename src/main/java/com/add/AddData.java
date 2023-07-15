package com.add;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.welcome.dao.WelcomeDao;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

import com.welcome.dao.DatabaseReader;

@WebServlet("/AddData")
public class AddData extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Data d=new Data();
		String title,quantity,size,image;
		response.setContentType("text/plain");
		title=(String) request.getParameter("title");
		quantity=(String) request.getParameter("quantity");
		size=(String) request.getParameter("size");
		image=(String) request.getParameter("image");
		WelcomeDao w= new WelcomeDao();
		try {
			if(w.check(title,quantity,size,image)) {
				DatabaseReader dr= new DatabaseReader();
				List<String[]> dataList =dr.readDataFromTable();
				System.out.println(dataList);
				request.setAttribute("dataList",dataList);
				RequestDispatcher dispatcher =request.getRequestDispatcher("welcome1.jsp");
				dispatcher.forward(request,response);
				//response.sendRedirect("welcome.jsp");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		d.setTitle(title);
		d.setQuantity(quantity);
		d.setSize(size);
		d.setImage(image);
		Configuration con = new Configuration().configure().addAnnotatedClass(Data.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(d);

		tx.commit();
*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
