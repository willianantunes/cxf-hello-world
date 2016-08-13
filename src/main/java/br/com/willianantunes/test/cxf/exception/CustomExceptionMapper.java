package br.com.willianantunes.test.cxf.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author Willian Antunes
 * @see <a href="http://cxf.apache.org/docs/jax-rs-basics.html#JAX-RSBasics-Exceptions">JAX-RS Basics - Exceptions</a>
 * @see <a href="https://jax-rs-spec.java.net/nonav/2.0/apidocs/javax/ws/rs/package-frame.html">Built-in exceptions classes</a>
 * @see <a href="http://cxf.apache.org/docs/jax-rs-basics.html#JAX-RSBasics-Exceptionhandling">Exception handling</a>
 */
public class CustomExceptionMapper implements ExceptionMapper<MyException> {

	@Override
	public Response toResponse(MyException exception) {
		return Response
				.status(Response.Status.CONFLICT)
				.entity(new ErrorResponse(
						exception.getClass().toString(), 
						exception.getMessage()))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
