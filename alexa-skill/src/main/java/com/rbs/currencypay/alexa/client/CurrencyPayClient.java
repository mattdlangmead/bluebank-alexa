package com.rbs.currencypay.alexa.client;

import java.util.Collection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class CurrencyPayClient {

	private static GenericType<Collection<PaymentInstruction>> paymentType = new GenericType<Collection<PaymentInstruction>>() {
	};
	private static GenericType<Collection<Account>> accountTtype = new GenericType<Collection<Account>>() {
	};

	private static final String BASE_URI = "http://iebs.uksouth.cloudapp.azure.com:8080";
	private Client client = ClientBuilder.newClient().register(JacksonJaxbJsonProvider.class); // .register(JacksonObjectMapperProvider.class);

	public Collection<PaymentInstruction> getPaymentActivity() {
		Collection<PaymentInstruction> payments = client.target(BASE_URI).path("v1/payments/list")
				.request(MediaType.APPLICATION_JSON_TYPE).get(paymentType);
		return payments;
	}

	public Collection<Account> getAccounts() {
		Collection<Account> accounts = client.target(BASE_URI).path("v1/static/accounts")
				.request(MediaType.APPLICATION_JSON_TYPE).get(accountTtype);
		return accounts;
	}
}
