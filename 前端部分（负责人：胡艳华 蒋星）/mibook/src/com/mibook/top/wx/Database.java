package com.mibook.top.wx;
import java.sql.*;
/*
*  微信js接口数据库缓存连接部分：
* */
public class Database {
	Connection con=null;
	public Database(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=java.sql.DriverManager.getConnection
					("jdbc:mysql://120.78.158.253:3306/mibook","huyanhua","9875520Aa.");
			//stat=con.createStatement(); 
		}catch(Exception e){}	
	}
}