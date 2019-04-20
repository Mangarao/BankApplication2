package com.nxtvision.banking.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nxtvision.banking.dao.DBConnectionDAO;

public class LoginBean {
	private String userId;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validateLogin() throws Exception{
		Connection conn = DBConnectionDAO.getConnection();
		if(conn!=null){
			PreparedStatement pstmt = conn.prepareStatement("select * from login where userid=? and password=?");
			pstmt.setString(1, userId);
			pstmt.setString(2,password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
			return false;
			
			
		}else{
			throw new Exception("Connection is not established");
		}
	}

}
