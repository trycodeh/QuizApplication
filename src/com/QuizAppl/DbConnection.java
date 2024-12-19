package com.QuizAppl;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	String driver_name ="oracle.jdbc.driver.OracleDriver";
	String driver_url ="jdbc:oracle:thin:@localhost:1521:xe";
	String userName ="system";
	String password ="root";
	
	public Connection getConnection () throws Exception {
		Class.forName(driver_name);
	  Connection connection= DriverManager.getConnection(driver_url,userName,password);
	  
	  return connection;
	}
}
