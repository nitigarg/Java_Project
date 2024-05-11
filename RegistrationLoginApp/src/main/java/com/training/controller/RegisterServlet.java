package com.training.controller;

import java.io.IOException;

import com.training.entity.User;
import com.training.service.AddUser;
import com.training.service.ViewUser;
import com.training.utility.ValidationException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int resultId = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddUser addUser = new AddUser();
		ViewUser viewUser = new ViewUser();
		User user = new User();
		boolean alreadyRegistered = true;
		/* 1.Fetching parameters view page */
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		/* 2.Setting values in User object */
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);

		response.setContentType("text/html");
		HttpSession session = request.getSession();

		/* 3.service layer communication with DAO layer */
		try {
			// check if userName already Registered
			alreadyRegistered = viewUser.check(user);
			System.out.println(alreadyRegistered);
			if (alreadyRegistered == false) {
				resultId = addUser.add(user);
				if (resultId == 1) {
					RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				} else {
					session.setAttribute("errors", ValidationException.getErrorMessage());
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.include(request, response);
				}
			} else {
				System.out.println("RegisterServlet: Inside else block");
				session.setAttribute("errors", "UserName already exists");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {

			e.getMessage();

		}
	}
}
