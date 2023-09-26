package com.infinite.servlet;

/**
 * @author laxmikanthm
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VotetoCheck
 */
public class VotetoCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection on = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotetoCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			/*response.setContentType("html/text");
			PrintWriter out=response.getWriter();*/
			
			ServletConfig cg = getServletConfig();
			Class.forName(cg.getInitParameter("mysql")); 
			on = DriverManager.getConnection(cg.getInitParameter("mysqlurl"), cg.getInitParameter("mysqlusername"),
					cg.getInitParameter("mysqlpassword"));  // loading the drivers
			PreparedStatement ps=on.prepareStatement("Insert into voterlist values(?,?,?,?,?);"); // for initalizing values using prepare statement
			ps.setString(1,request.getParameter("fullname"));
			ps.setInt(2,Integer.valueOf(request.getParameter("age")));
			ps.setString(3,request.getParameter("father_name"));
			ps.setString(4,request.getParameter("email"));
			ps.setString(5,request.getParameter("country"));
			ps.executeUpdate();
			ps.close();
			response.sendRedirect("Display1.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try{
				on.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	}
	}

