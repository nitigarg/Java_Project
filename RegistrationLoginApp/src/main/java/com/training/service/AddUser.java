package com.training.service;

import com.training.DAO.UserDAO;
import com.training.DAO.UserDAOImpl;
import com.training.entity.User;
import com.training.utility.Validation;
import com.training.utility.ValidationException;

public class AddUser {

	public int add(User user)throws ValidationException,Exception {
		int resultId =0;
		UserDAO userDAO=null;
		StringBuffer allMessages=new StringBuffer();
		Validation validation=new Validation();
		String errorMessage=validation.validateFirstName(user.getFirstName());
		allMessages.append(errorMessage);
		errorMessage=validation.validateLastName(user.getLastName());
		allMessages.append(errorMessage);
		errorMessage=validation.validateUserName(user.getUserName());
		allMessages.append(errorMessage);
		errorMessage=validation.validatePassword(user.getPassword());
		allMessages.append(errorMessage);
		
		//If there are no error messages then we will sent call to Db layer
		if(allMessages.length()==0)
		{
			userDAO=new UserDAOImpl();
			resultId=userDAO.add(user);
		}
		else {
			new ValidationException(allMessages.toString());
			
		}
		return resultId;
	}

}
