package com.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("txtpid"));
		String pname=request.getParameter("txtpname");
		int qty=Integer.parseInt(request.getParameter("txtqty"));
		int price=Integer.parseInt(request.getParameter("txtprice"));
		int total=price*qty;
		PrintWriter out=response.getWriter();
	
		try {
			//Call Connection Method
				Connection con=DBConnection.getMyConnection();
			//Write sql command
				String str="Insert into Product (pid, pname,qty,price,total) values(?,?,?,?,?)";
				
				PreparedStatement  ps=con.prepareStatement(str);
				ps.setInt(1,pid );
				ps.setString(2, pname);
				ps.setInt(3, qty);
				ps.setInt(4, price);
				ps.setInt(5, total);
				int ans =ps.executeUpdate();
				
				if(ans>0)
					out.println("Record inserted");
				else
					out.println("Record not inserted");
				con.close();
				}
		catch(Exception e) {
			e.printStackTrace();
		}
}
}