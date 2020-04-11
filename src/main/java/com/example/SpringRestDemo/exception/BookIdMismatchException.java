package com.example.SpringRestDemo.exception;

public class BookIdMismatchException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6469719652014867298L;

	public BookIdMismatchException() {
        super();
    }

    public BookIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookIdMismatchException(final String message) {
        super(message);
    }

    public BookIdMismatchException(final Throwable cause) {
        super(cause);
    }	

}
