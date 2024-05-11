package com.training.utility;


/**
 * This class will be use for validation of different form fields
 */
public class Validation {

	private boolean isFieldBlankOrNull(String field) {
		if (field == null || field.trim().equals("")) {
			return true;
		}
		return false;
	}

	public String validateFirstName(String firstName) {
		if (isFieldBlankOrNull(firstName)) {
			return ErrorMessageCodes.FIRST_NAME_IS_BLANK;
		}
		return "";

	}

	public String validateLastName(String lastName) {
		if (isFieldBlankOrNull(lastName)) {
			return ErrorMessageCodes.LAST_NAME_IS_BLANK;
		}
		return "";

	}

	public String validateUserName(String userName) {
		if (isFieldBlankOrNull(userName)) {
			return ErrorMessageCodes.USER_NAME_IS_BLANK;
		}
		return "";

	}

	public String validatePassword(String password) {
		if (isFieldBlankOrNull(password)) {
			return ErrorMessageCodes.PASSWORD_IS_BLANK;
		}
		return "";

	}
}
