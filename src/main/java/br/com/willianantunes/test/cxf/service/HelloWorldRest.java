package br.com.willianantunes.test.cxf.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * A classical Hello World web service REST program.
 * @author Willian Antunes
 * @see <a href="https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples">Samples</a>
 */
public interface HelloWorldRest {
	@GET
	@Path("/hello-world-rs/{text}")	
	@Produces(MediaType.TEXT_PLAIN)
	String sayHello(@PathParam("text") String text);
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/hello-world-rs/exception-type-one")
	String forceExceptionTest(@FormParam("stringParam") String stringParam, @FormParam("integerValue") Integer integerValue);
	
	@GET
	@Path("/hello-world-exception/two")
	void forceExceptionTestTwo();

	@GET
	@Path("/hello-world-exception/three")
	void forceExceptionTestThree();
	
	@GET
	@Path("/hello-world-exception/four")
	void forceExceptionTestFour();
}
