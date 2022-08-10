package com.businesslogin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pid = request.getParameter("productId");
		String pname = request.getParameter("productName");
		String pprice = request.getParameter("productPrice");
		//redirecting to display details
		HttpSession session = request.getSession();		
		session.setAttribute("pid", pid);
		session.setAttribute("pname", pname);
		session.setAttribute("pprice", pprice);		
		response.sendRedirect("ProductDetails.jsp");		
		
	}

}


