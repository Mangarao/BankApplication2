package com.nxtvision.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nxtvision.banking.dao.AccountDAO;
import com.nxtvision.banking.model.AccountBean;

/**
 * Servlet implementation class CheckBalanceServlet
 */
@WebServlet("/checkBalanceServlet")
public class CheckBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountNumber = (String)session.getAttribute("ACCOUNT_NUMBER");
		AccountDAO accountDAO = new AccountDAO();
		try {
			AccountBean accountBean = accountDAO.getAccountDetailsByAccNum(accountNumber);
			request.setAttribute("ACCOUNT_BEAN",accountBean);
			request.getRequestDispatcher("/checkBalance.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
