package com.training.service;

import java.sql.SQLException;

import com.training.DAO.UserDAO;
import com.training.DAO.UserDAOImpl;
import com.training.entity.User;
import com.training.utility.Validation;
import com.training.utility.ValidationException;

public class ViewUser {

	public String view(User user) throws ValidationException, Exception {
		UserDAO userDAO = null;
		String firstName = "";
		StringBuffer allMessages = new StringBuffer();
		Validation validation = new Validation();
		String errorMessage = validation.validateUserName(user.getUserName());
		allMessages.append(errorMessage);
		errorMessage = validation.validatePassword(user.getPassword());
		allMessages.append(errorMessage);

		// If there are no error messages then we will sent call to Db layer
		if (allMessages.length() == 0) {
			userDAO = new UserDAOImpl();
			firstName = userDAO.view(user);
		} else {
			new ValidationException(allMessages.toString());

		}
		return firstName;
	}

	public boolean check(User user) {
		UserDAO userDAO = new UserDAOImpl();
		boolean alreadyRegistered = false;
		try {
			alreadyRegistered = userDAO.checkUser(user);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alreadyRegistered;
	}
}
