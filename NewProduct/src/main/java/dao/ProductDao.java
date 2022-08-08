package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import beans.Product;
import java.util.*;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;

public class ProductDao 
{
	public int storeProduct(Product product) 
	{
		try 
		{
			Configuration con=new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory sf=con.buildSessionFactory();
			Session session=sf.openSession();
			Transaction tran=session.getTransaction();
			tran.begin();
			session.save(product);
			tran.commit();
			return 1;
		}
		catch(Exception e) 
		{
			System.out.println(e);
			return 0;
		}
	}		
}

