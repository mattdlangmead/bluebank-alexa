package com.rbs.currencypay.alexa.client;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonObjectMapperProvider extends JacksonJaxbJsonProvider {
	public JacksonObjectMapperProvider() {
		super();
		setMapper(ObjectMapperFactory.create());
	}
}
