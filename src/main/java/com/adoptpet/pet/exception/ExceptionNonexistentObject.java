package com.adoptpet.pet.exception;

/**
 *Handling Errors on Nonexistent Objects
 *
 * @author jessikafernandes
 * @since 02/01/2020
 */

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