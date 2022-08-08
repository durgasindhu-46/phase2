package com.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import dao.ProductDao;
import service.ProductService;

/**
 * Servlet implementation class InsertController
 */
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		float price=Float.parseFloat(request.getParameter("price"));
		Product pp=new Product();
		pp.setId(id);
		pp.setName(name);
		pp.setPrice(price);
		ProductService ps=new ProductService();
		String result=ps.storeProduct(pp);
		out.println(result);
		RequestDispatcher rd1=request.getRequestDispatcher("insert.html");
		rd1.include(request,response);
	}

}

