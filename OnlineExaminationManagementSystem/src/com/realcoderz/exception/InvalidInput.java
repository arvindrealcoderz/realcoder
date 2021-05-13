package com.realcoderz.exception;

public class InvalidInput extends Exception {
	public InvalidInput() {
		System.out.println("InvalidInput o param constructor ");
	}
	public InvalidInput(String message) {
		super(message);
	}
	public String getMessage()
	{
		System.out.println("InvalidInput.getMessage()");
		return super.getMessage();
	}
}
