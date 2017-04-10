package com.rbs.currencypay.alexa;

import java.util.Collection;

import org.junit.Test;

import com.rbs.currencypay.alexa.client.Account;
import com.rbs.currencypay.alexa.client.CurrencyPayClient;
import com.rbs.currencypay.alexa.client.PaymentInstruction;

public class CurrencyPayClientTest {

	private CurrencyPayClient client = new CurrencyPayClient();

	// @Ignore
	@Test
	public void testPayments() {
		Collection<PaymentInstruction> paymentActivity = client.getPaymentActivity();
		System.out.println(paymentActivity);
	}

	@Test
	public void testAccounts() {
		Collection<Account> accounts = client.getAccounts();
		System.out.println(accounts);
	}
}
