package com.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ParticularProduct")
public class ParticularProduct extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Connection con=DBConnection.getMyConnection();
		
		   int pid=Integer.parseInt(request.getParameter("txtpid"));
    	   String query="select * from product where pid=?";     
     	   PreparedStatement st=  con.prepareStatement(query);
	      st.setInt(1, pid);
	      ResultSet rs =st.executeQuery();
	      out.print("<h2>Displaying the Particular Product Details...</h2>");	
	      if(rs.next()) {
	    	  out.println("<table border=2>");
				out.println("<tr><th>ProductId</th><th>ProductName</th><th>Quality</th><th>Price</th><th>Total</th></tr>");
	    	  out.println("<tr>");
				out.print("<td>"+rs.getInt("pid")+"</td>");
				out.print("<td>"+rs.getString("pname")+"</td>");
				out.print("<td>"+rs.getInt("qty")+"</td>");
				out.print("<td>"+rs.getInt("price")+"</td>");
				out.print("<td>"+rs.getInt("total")+"</td>");
				out.println("</tr>");	    	    	  
			}
	      else {
	    	  out.print("No product with Product Id: "+pid);
	      }
	      out.print("</table>");
	      con.close();			
		}		
		catch(Exception e){
			
			System.out.println("Some Issue : "+ e.getMessage());
			}		
	}	
}


