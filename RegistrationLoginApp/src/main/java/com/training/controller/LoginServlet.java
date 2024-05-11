package com.training.controller;

import java.io.IOException;
import java.util.List;

import com.training.entity.OrderDetails;
import com.training.entity.User;
import com.training.service.ViewOrderTable;
import com.training.service.ViewUser;
import com.training.utility.ValidationException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet:Inside do Post");
		User user = new User();
		String firstName = "";

		/* Step1. Getting parameters from form page */
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		/* Step2. Setting values in User object */
		user.setUserName(userName);
		user.setPassword(password);

		/* setting values in session */
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		/* Calling service layer */
		ViewUser viewUser = new ViewUser();

		try {
			firstName = viewUser.view(user);

			if (firstName.length() != 0) {
				session.setAttribute("firstName", firstName);
				ViewOrderTable viewOrderDetails=new ViewOrderTable();
				List<OrderDetails> list=viewOrderDetails.viewOrderDetails();
				request.setAttribute("list",list);
				RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("errors", ValidationException.getErrorMessage());
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}

		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
