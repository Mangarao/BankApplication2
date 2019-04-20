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
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/withdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String withdrawAmount = request.getParameter("withdrawAmount");
		AccountDAO accountDAO = new AccountDAO();
		HttpSession session = request.getSession();
		String accountNumber = (String) session.getAttribute("ACCOUNT_NUMBER");
		int count;
		try {
			count = accountDAO.withdrawAmount(Double.parseDouble(withdrawAmount),accountNumber);
		PrintWriter pw = response.getWriter();
		if(count>0){
			pw.println(withdrawAmount+" is withdrawn....");
			request.getRequestDispatcher("/home.jsp").include(request, response);
		}else{
			pw.println(withdrawAmount+" is not withdrawn....");
			request.getRequestDispatcher("/home.jsp").include(request, response);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
