package com.adoptpet.pet.exception;

public class ExceptionNonexistentObject extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer code = 1;

	public ExceptionNonexistentObject(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}

}