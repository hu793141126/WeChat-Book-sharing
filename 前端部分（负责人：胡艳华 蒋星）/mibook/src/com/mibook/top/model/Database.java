package com.mibook.top.model;
import java.sql.*;

public class Database {		//连接数据库类         
	Connection con=null;
	public Database(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=java.sql.DriverManager.getConnection("jdbc:mysql://120.78.158.253:3306/mibook","huyanhua","9875520Aa.");
		}catch(Exception e){}
	}
}