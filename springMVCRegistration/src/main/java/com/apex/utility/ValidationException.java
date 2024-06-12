package com.apex.utility;

public class ValidationException extends Exception{
	private static final long serialVersionUID = 1L;
	private static String errorMessage;

	@Override
	public String toString() {
		return "ValidationException [errorMessage=" + errorMessage + "]";
	}

	public ValidationException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
