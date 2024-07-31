package net.javaguides.todo.exception;

import org.springframework.http.HttpStatus;

public class TodoAPIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;

	public TodoAPIException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
