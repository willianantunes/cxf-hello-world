package br.com.willianantunes.test.cxf.resolver;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @author Willian Antunes
 * @see <a href="http://stackoverflow.com/questions/29571587/deserializing-localdatetime-with-jackson-jsr310-module">Deserializing LocalDateTime with Jackson JSR310 module</a>
 * @see <a href="http://stackoverflow.com/questions/35367366/can-you-set-jackons-include-non-null-globally-in-jax-rs">Can you set Jackon's Include.NON_NULL globally in JAX-RS?</a>
 * 
 */
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
	
	private final ObjectMapper mapper;

	public ObjectMapperContextResolver() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}

}
