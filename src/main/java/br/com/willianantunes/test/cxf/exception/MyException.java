package br.com.willianantunes.test.cxf.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class MyException extends WebApplicationException {

	public MyException(String message, Status status) {
		super(message, status);
	}
	
}
