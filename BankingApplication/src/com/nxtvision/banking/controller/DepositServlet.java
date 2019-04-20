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
import com.nxtvision.banking.model.AccountBean;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/depositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String depositAmount = request.getParameter("depositAmount");
		AccountDAO accountDAO = new AccountDAO();
		HttpSession session = request.getSession();
		String accountNumber = (String) session.getAttribute("ACCOUNT_NUMBER");
		int count = accountDAO.depositAmount(Double.parseDouble(depositAmount),accountNumber);
		PrintWriter pw = response.getWriter();
		if(count>0){
			pw.println(depositAmount+" is deposited....");
			request.getRequestDispatcher("/home.jsp").include(request, response);
		}else{
			pw.println(depositAmount+" is not deposited....");
			request.getRequestDispatcher("/home.jsp").include(request, response);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
