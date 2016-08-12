package br.com.willianantunes.test.cxf.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorldImpl implements HelloWorld {
	
	private final Logger logger = LogManager.getLogger(HelloWorldImpl.class);
	
	@Override
	public String sayHello(String text) {
		logger.info("I received {}", text);
		return "You have sent " + text;
	}

}
