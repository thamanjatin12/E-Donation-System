package com.DonationManagement.Exceptions;

public class NGONotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NGONotFoundException() {
		
	}
	
	public NGONotFoundException(String string) {
		super(string);
	}

}
