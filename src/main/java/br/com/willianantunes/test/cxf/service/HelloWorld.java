package br.com.willianantunes.test.cxf.service;

import javax.jws.WebService;

/**
 * A classical Hello World web service SOAP program.
 * @author Willian Antunes
 * @see <a href="https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples">Samples</a>
 */
@WebService
public interface HelloWorld {
	String sayHello(String text);
}
