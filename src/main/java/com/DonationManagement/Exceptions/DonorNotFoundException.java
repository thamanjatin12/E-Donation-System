package com.DonationManagement.Exceptions;

public class DonorNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DonorNotFoundException() {
		
	}
	
	public DonorNotFoundException(String string) {
		super(string);
		
	}

}
