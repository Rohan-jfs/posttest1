package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControllerCard")
public class ControllerCard extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int counter=0;
		String name=request.getParameter("name");
		String cvv=request.getParameter("cvv");
		String card_number=request.getParameter("card_number");
		String expiry_month=request.getParameter("expiry_month");
		String expiry_year=request.getParameter("expiry_year");
		String expiry_date=expiry_month+"/"+expiry_year;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
		
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from tcard");
			while(resultSet.next()) {
				String card_number_db= resultSet.getString("CARD_NO");
				String card_holder_name= resultSet.getString("CARD_HOLDER_NAME");
				String cvv_db= resultSet.getString("CVV");
				String expiry_date_db= resultSet.getString("EXPIRY_DATE");
				if(card_number_db.equals(card_number) && card_holder_name.equals(name) && cvv_db.equals(cvv) && expiry_date_db.equals(expiry_date)  )
				{
					counter++;
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.html");
					requestDispatcher.forward(request, response);
				}
			}
			if(counter==0)
			{
			
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.html");
				requestDispatcher.forward(request, response);
			
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Error.html");
//			requestDispatcher.forward(request, response);
		}

		}
}
