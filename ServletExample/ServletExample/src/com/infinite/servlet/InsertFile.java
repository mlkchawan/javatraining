package com.infinite.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class InsertFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection on = null;

       
    
    public InsertFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			response.setContentType("html/text");
			PrintWriter out=response.getWriter();
			ServletConfig cg = getServletConfig();
			Class.forName(cg.getInitParameter("mysql"));
			on = DriverManager.getConnection(cg.getInitParameter("mysqlurl"), cg.getInitParameter("mysqlusername"),
					cg.getInitParameter("mysqlpassword"));
			Statement st=on.createStatement();
			//Scanner s=new Scanner(System.in);
			PreparedStatement ps=on.prepareStatement("Insert into register values(?,?,?,?,?);");
			ps.setString(1,request.getParameter("stdname"));
			ps.setInt(2,Integer.valueOf(request.getParameter("stdid")));
			ps.setInt(3,Integer.valueOf(request.getParameter("age")));
			ps.setString(4,request.getParameter("email"));
			ps.setString(5,request.getParameter("branch"));
			ps.executeUpdate();
			ps.close();
			response.sendRedirect("Success.html");
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

