package com.nxtvision.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nxtvision.banking.model.AccountBean;

public class AccountDAO {
	
	public String getAccountDetailsByUserId(String userId) throws Exception{
		Connection conn = DBConnectionDAO.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select ACCOUNT_NUMBER from account where userid=?");
		pstmt.setString(1,userId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getString(1);
		}
		return null;
	}
	
	public AccountBean getAccountDetailsByAccNum(String accountNum) throws Exception{
		Connection conn = DBConnectionDAO.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from account where account_number=?");
		pstmt.setString(1,accountNum);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			AccountBean accountBean = new AccountBean();
			accountBean.setAccountNumber(rs.getString(1));
			accountBean.setFirstName(rs.getString(2));
			accountBean.setLastName(rs.getString(3));
			accountBean.setBalance(rs.getDouble(4));
			accountBean.setUserId(rs.getString(5));
			return accountBean;
		}
		return null;
	}
	
	public int depositAmount(double depositAmount, String accountNumber)throws Exception{
		Connection conn = DBConnectionDAO.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update account set balance=balance+? where account_number=?");
		pstmt.setDouble(1, depositAmount);
		pstmt.setString(2, accountNumber);
		return pstmt.executeUpdate();
		
	}
	
	public int withdrawAmount(double depositAmount, String accountNumber)throws Exception{
		Connection conn = DBConnectionDAO.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update account set balance=balance-? where account_number=?");
		pstmt.setDouble(1, depositAmount);
		pstmt.setString(2, accountNumber);
		return pstmt.executeUpdate();
		
	}
	
	public boolean transferAmount(double tranferAmount, String fromAccountNumber,String toAccoutnNumber)throws Exception{
		boolean flag = false;
		Connection conn = DBConnectionDAO.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("update account set balance=balance-? where account_number=?");
			pstmt.setDouble(1, tranferAmount);
			pstmt.setString(2, fromAccountNumber);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("update account set balance=balance+? where account_number=?");
			pstmt.setDouble(1, tranferAmount);
			pstmt.setString(2, toAccoutnNumber);
			pstmt.executeUpdate();
			conn.commit();
			flag = true;
		} catch (Exception e) {
			conn.rollback();
			flag = false;
		}
		
		return flag;
		
	}

}
