package br.com.willianantunes.test.cxf.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/hello-world-rs/{text}")
	String sayHello(@PathParam("text") String text);
}
