package com.adoptpet.pet.exception;

/**
 *Handling Errors on Nonexistent Objects
 *
 * @author jessikafernandes
 * @since 02/01/2020
 */

public class ExceptionNonexistentObject extends RuntimeException {

	public ExceptionNonexistentObject(String message) {
		super(message);
	}

}