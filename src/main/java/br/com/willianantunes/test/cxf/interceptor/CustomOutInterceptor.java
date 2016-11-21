package br.com.willianantunes.test.cxf.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * If a ExceptionMapper catch the WebApplicationException, then this interceptor won't be evoked.
 * @author Willian Antunes
 * @see <a href="http://cxf.apache.org/docs/interceptors.html#Interceptors-WritingandconfiguringanInterceptor">Writing and configuring an Interceptor</a>
 */
public class CustomOutInterceptor extends AbstractPhaseInterceptor<Message> {

	public CustomOutInterceptor() {
		// Opening of the connection
		super(Phase.PREPARE_SEND);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		// Listing all of the entries
		message.getExchange()
			.forEach((k, v) -> System.out.println(k + " --- " + v));

		if (message.getExchange().get("java.lang.Exception") == null) {
            return;
        }
		Exception exception = message.getContent(Exception.class);
		
		// If you call "/hello-world-exception/six", then you must get "Hã?!?!?!" message
		System.out.println(exception.getMessage());
		System.out.println("end");
	}

}
