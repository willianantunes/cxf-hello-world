package br.com.willianantunes.test.cxf.service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorldRestImpl implements HelloWorldRest {

	private final Logger logger = LogManager.getLogger(HelloWorldRestImpl.class);
	
	@Override
	public String sayHello(String text) {
		logger.info("I received {}", text);
		return "You have sent " + text;
	}

	@Override
	public String forceExceptionTest(String stringParam, Integer integerValue) {
		logger.info("stringParam and integerValue have {} and {} respectively", stringParam, integerValue);
		
		if(stringParam == null || stringParam.equals(""))
			 throw new WebApplicationException("It worked as expected. Analise your client and see whether it's caught 303 return code or not.", Response.Status.SEE_OTHER);

		return "It would never be reached if you test it right!";
	}

	@Override
	public void forceExceptionTestTwo() {		
		// The log entry for this RUNTIME exception is written as WARN
		throw new BadRequestException("It's my test two!");
	}
}
