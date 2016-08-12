package br.com.willianantunes.test.cxf.handler;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHandler implements SOAPHandler<SOAPMessageContext> {
	
	private final Logger logger = LogManager.getLogger(LogHandler.class);
	
	@Override
	public void close(MessageContext messageContext) { }

	@Override
	public boolean handleFault(SOAPMessageContext soapMessageContext) {
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext soapMessageContext) {
		try {
			// Message direction, true for outbound messages, false for inbound
			Boolean isRequest = (Boolean) soapMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			
			SOAPMessage soapMessage = soapMessageContext.getMessage();
			// Printing the message on the console
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			soapMessage.writeTo(out);
			String responseMessage = new String(out.toByteArray());
			
			logger.trace("Message direction: {}", isRequest == true ? "Outbound" : "Inbound");
			logger.trace(String.format("Entire message: \r\n%s", responseMessage));
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}		
		
		// Continue other handler chain
		return true;
	}

	@Override
	public Set<QName> getHeaders() {		
		return null;
	}
}