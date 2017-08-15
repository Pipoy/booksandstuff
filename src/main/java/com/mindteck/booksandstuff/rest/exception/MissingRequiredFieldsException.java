package com.mindteck.booksandstuff.rest.exception;

/**
 * Created by Philip Lozada on 8/14/2017.
 */
public class MissingRequiredFieldsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MissingRequiredFieldsException(final String message){
		super(message);
	}

	public MissingRequiredFieldsException(final String message, final Throwable cause){
		super(message, cause);

	}

	public MissingRequiredFieldsException(final Throwable cause){
		super(cause);
	}
}
