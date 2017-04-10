package com.rbs.currencypay.alexa.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * 
 * @author <a href="mailto:daniel.siviter@rbs.com">Daniel Siviter</a>
 * @since v1.0 [17 Nov 2014]
 */
public class ObjectMapperFactory {

	private ObjectMapperFactory() {
	}

	public static ObjectMapper create() {
		final ObjectMapper mapper = new ObjectMapper();
		// mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); //
		// use
		// ISO8601
		// format
		// mapper.registerModule(new GuavaModule());
		mapper.registerModule(new JodaModule());
		return mapper;
	}
}
