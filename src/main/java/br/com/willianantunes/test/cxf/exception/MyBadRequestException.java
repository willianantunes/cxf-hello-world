package br.com.willianantunes.test.cxf.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.willianantunes.test.cxf.model.MyMessageModel;

public class MyBadRequestException extends WebApplicationException {

	public MyBadRequestException(String message) {
		super(Response
				.status(Response.Status.BAD_REQUEST)
				.entity(message).type(MediaType.TEXT_PLAIN).build());
	}
	
	public MyBadRequestException(MyMessageModel myMessageModel, String mediaType) {
		super(myMessageModel.getMessage(), Response
				.status(Response.Status.BAD_REQUEST)
				.entity(myMessageModel).type(mediaType).build());
	}	

}
