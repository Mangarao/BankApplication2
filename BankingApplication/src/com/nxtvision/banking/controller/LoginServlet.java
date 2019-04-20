package com.nxtvision.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nxtvision.banking.dao.AccountDAO;
import com.nxtvision.banking.model.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			LoginBean loginBean = new LoginBean();
			loginBean.setUserId(userId);
			loginBean.setPassword(password);
			if(loginBean.validateLogin()){
				//login success
				AccountDAO accountDAO = new AccountDAO();
				String accountNumber = accountDAO.getAccountDetailsByUserId(userId);
				HttpSession session = request.getSession();
				session.setAttribute("ACCOUNT_NUMBER", accountNumber);
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
			}else{
				//login failure
				PrintWriter pw = response.getWriter();
				pw.println("<h1 style='color:red'>Invalid userid or password.. Please try again</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
