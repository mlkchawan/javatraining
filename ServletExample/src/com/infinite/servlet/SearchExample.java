package com.infinite.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchExample
 */
public class SearchExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection on = null;

	public SearchExample() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			Class.forName("com.mysql.jdbc.Driver"); // loading the drivers
			Connection on = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "mysql123@"); // estabilishing
																														// connection
			System.out.println("Connection established to database");
		   Statement stmt = on.createStatement(); // creating statement
		   out.println("<html><body>");
		   out.println("<tr>"+"<td>fullname</td>"+"<td>idno</td>"+"<td>department</td>");
		   ResultSet rs = stmt.executeQuery("select *from employee");
			while (rs.next()) {
				out.println("<tr>"+"<td>"+rs.getString("fullname")+"</td>"+"<td>"+rs.getInt("idno")+"</td>"+"<td>"+ rs.getString("department")+"</td>"+"</tr>");
			}
			rs.close();
			stmt.close();

		} catch (Exception e1) {
			System.out.println(e1);
		}
		finally {
			try {
				on.close();
			} catch (Exception e1) {
				System.out.println(e1);

			}
		}
	}

	
}
