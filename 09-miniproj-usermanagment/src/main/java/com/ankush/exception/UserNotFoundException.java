package com.ankush.exception;

public class UserNotFoundException extends RuntimeException{
	
	
	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserNotFoundException(String email) {
		super(email);
	}
	
	
	

}
