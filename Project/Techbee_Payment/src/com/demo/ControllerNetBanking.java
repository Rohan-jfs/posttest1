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

/**
 * Servlet implementation class ControllerNetBanking
 */
@WebServlet("/ControllerNetBanking")
public class ControllerNetBanking extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		int counter = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from tnetbanking");
			while (resultSet.next()) {
				String username_db = resultSet.getString("USER_NAME");
				String password_db = resultSet.getString("PASSWORD");


				if (username.equals(username_db) && password.equals(password_db)) {

					counter++;
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.html");
					requestDispatcher.forward(request, response);
					break;
				}
			}
			if (counter == 0) {

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
