package com.apex.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.apex.beans.User;
import com.apex.dao.UserDao;
import com.apex.dao.UserDaoImpl;
import com.apex.utility.Validation;
import com.apex.utility.ValidationException;


@Service
public class ViewUser {
	public String view(User user) throws ValidationException, Exception {
		UserDao userDAO = null;
		String firstName = "";
		StringBuffer allMessages = new StringBuffer();
		Validation validation = new Validation();
		String errorMessage = validation.validateUserName(user.getUserName());
		allMessages.append(errorMessage);
		errorMessage = validation.validatePassword(user.getPassword());
		allMessages.append(errorMessage);

		// If there are no error messages then we will sent call to Db layer
		if (allMessages.length() == 0) {
			userDAO = new UserDaoImpl();
			firstName = userDAO.view(user);
		} else {
			new ValidationException(allMessages.toString());

		}
		return firstName;
	}

	public boolean check(User user) {
		UserDao userDAO = new UserDaoImpl();
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
