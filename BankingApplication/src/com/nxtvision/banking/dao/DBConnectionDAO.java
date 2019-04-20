package com.nxtvision.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionDAO {
	
	static Connection con = null;
	
	public static Connection getConnection() throws Exception{
		if(con==null){
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//step2 create  the connection object  
		con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
		}
		return con;
	}

	public void closeConnection(Connection conn) throws SQLException{
		if(conn!=null){
			conn.close();
		}
	}


}
