package com.nxtvision.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nxtvision.banking.dao.AccountDAO;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/transferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			String accountNumber = (String) session.getAttribute("ACCOUNT_NUMBER");
			String toAccountNumber = request.getParameter("toAccountNumber");
			String transferAmount = request.getParameter("transferAmount");
			AccountDAO accountDAO = new AccountDAO();
			boolean flag = accountDAO.transferAmount(Double.parseDouble(transferAmount), accountNumber, toAccountNumber);
		PrintWriter pw = response.getWriter();
		if(flag){
			pw.println(transferAmount+" is transferred successfully....");
			request.getRequestDispatcher("/home.jsp").include(request, response);
		}else{
			pw.println(transferAmount+" is not transferred....");
			request.getRequestDispatcher("/home.jsp").include(request, response);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	
	}

}
