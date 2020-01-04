package com.tektaurus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tektaurus.bean.Student;

public class productDAO {

	Connection con;
	PreparedStatement pre;
	ResultSet res;
	
	public productDAO()

	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","seed1234");
			System.out.println("Database Connected....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public int insert(product p)

	{
		System.out.println("In Insert");
		int ra=0;
		try
		{
			pre=con.prepareStatement("insert into product values(?,?,?,?)");
			pre.setInt(1, p.getid());
			pre.setString(2,p.getName());
			pre.setString(3, p.getprice());
			pre.setString(4,p.getcategory());
			ra=pre.executeUpdate();
			pre.close();
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ra;
	}
	public int update(product p)

	{
		System.out.println("In Update");
		int ra=0;
		try
		{
			pre=con.prepareStatement("update student set name=?,price=?,category=? where id=?");
			pre.setInt(5, p.getid());
			pre.setString(1,p.getName());
			pre.setString(2, p.getMobile());
			pre.setString(3,p.getAddress());
			pre.setString(4, p.getStream());
			ra=pre.executeUpdate();
			pre.close();
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ra;
	}

}
