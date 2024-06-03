package com.apex.service;

import org.springframework.stereotype.Service;

import com.apex.beans.User;
import com.apex.dao.UserDao;
import com.apex.dao.UserDaoImpl;
import com.apex.utility.Validation;
import com.apex.utility.ValidationException;

@Service
public class AddUser {
	
	
	public int add(User user) throws ValidationException, Exception {
		int resultId = 0;
		UserDao userDAO = null;
		StringBuffer allMessages = new StringBuffer();
		Validation validation = new Validation();
		String errorMessage = validation.validateFirstName(user.getFirstName());
		allMessages.append(errorMessage);
		errorMessage = validation.validateLastName(user.getLastName());
		allMessages.append(errorMessage);
		errorMessage = validation.validateUserName(user.getUserName());
		allMessages.append(errorMessage);
		errorMessage = validation.validatePassword(user.getPassword());
		allMessages.append(errorMessage);

		// If there are no error messages then we will sent call to Db layer
		if (allMessages.length() == 0) {
			userDAO = new UserDaoImpl();
			resultId = userDAO.add(user);
		} else {
			new ValidationException(allMessages.toString());

		}
		return resultId;
	}

}
