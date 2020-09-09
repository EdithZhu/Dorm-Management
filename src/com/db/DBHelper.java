package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/dorm?serverTimezone=UTC";
	private String dbUser="root";
	private String dbPassword="Zy@19960215";
	private String jdbcName="com.mysql.cj.jdbc.Driver";
	
	//get connection
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){}
		return conn;		
	}
	
	//main function
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
		
	}
	
}
