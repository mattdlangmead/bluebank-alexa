package com.rbs.currencypay.alexa;

import java.util.Arrays;
import java.util.Collection;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.rbs.currencypay.alexa.client.Account;
import com.rbs.currencypay.alexa.client.CurrencyPayClient;
import com.rbs.currencypay.alexa.client.PaymentInstruction;

import jersey.repackaged.com.google.common.base.Joiner;

public class CurrencyPaySpeechlet implements SpeechletV2 {

	private RateProvider rateProvider = new RateProvider();
	private CurrencyReconciler ccyReconciler = new CurrencyReconciler();
	private CurrencyPayClient cpClient = new CurrencyPayClient();

	@Override
	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
	}

	@Override
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText("Hello, welcome to Starling Bank. What can I do for you today?");
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(null);
		requestEnvelope.getContext();
		setInteractive(requestEnvelope, true);
		return SpeechletResponse.newAskResponse(speech, reprompt);
	}

	private void setInteractive(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope, boolean interactive) {
		requestEnvelope.getSession().setAttribute("interactive", interactive);
	}

	private boolean isInteractive(SpeechletRequestEnvelope<?> requestEnvelope) {
		Object attribute = requestEnvelope.getSession().getAttribute("interactive");
		return attribute == null ? false : (boolean) attribute;
	}

	@Override
	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		SpeechletResponse response = null;
		boolean interactive = isInteractive(requestEnvelope);
		String name = requestEnvelope.getRequest().getIntent().getName();
		if ("GetActivityIntent".equals(name)) {
			response = getPaymentHistory(interactive);
		} else if ("GetAccountBalanceIntent".equals(name)) {
			response = getAccounts(interactive);
		} else if ("GetRateIntent".equals(name)) {
			String baseCcy = requestEnvelope.getRequest().getIntent().getSlot("BaseCurrency").getValue();
			String quotedCcy = requestEnvelope.getRequest().getIntent().getSlot("QuotedCurrency").getValue();
			response = getRate(baseCcy, quotedCcy, interactive);
		} else {
			PlainTextOutputSpeech failSpeech = new PlainTextOutputSpeech();
			failSpeech.setText("The curse of the demo strikes again!");
			response = SpeechletResponse.newTellResponse(failSpeech);
		}
		return response;
	}

	private SpeechletResponse getAccounts(boolean interactive) {
		Collection<Account> accounts = cpClient.getAccounts();
		StringBuilder response = new StringBuilder();
		response.append("You have " + accounts.size() + " accounts, ");
		if (accounts.size() > 0) {
			Account account = accounts.iterator().next();
			response.append("The balance of account with sort code " + numberify(account.getSortCode())
					+ " and account number: " + numberify(account.getAccountNo()) + " is: ");
			response.append(account.getBalance() + " " + account.getCurrencyCode());
		}
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(response.toString());
		return createSpeechResponse(speech, interactive);
	}

	private SpeechletResponse createSpeechResponse(PlainTextOutputSpeech speech) {
		return createSpeechResponse(speech, false);
	}

	private SpeechletResponse createSpeechResponse(PlainTextOutputSpeech speech, boolean interactive) {
		// speech.setText(speech.getText() + " Is there anything else I can help
		// you with?");
		if (interactive) {
			return SpeechletResponse.newAskResponse(speech, new Reprompt());
		}
		return SpeechletResponse.newTellResponse(speech);
	}

	private String numberify(String source) {
		return Joiner.on(" ").join(Arrays.asList(source.split("")));
	}

	private SpeechletResponse getPaymentHistory(boolean interactive) {
		Collection<PaymentInstruction> paymentActivity = cpClient.getPaymentActivity();
		StringBuilder response = new StringBuilder();
		response.append("You have " + paymentActivity.size() + " payments in your activity, ");
		if (paymentActivity.size() > 0) {
			response.append("Here is your latest payment: ");
			PaymentInstruction payment = paymentActivity.iterator().next();
			if (payment.getRecipient() != null) {
				response.append("Payment to " + payment.getRecipient().getName() + ", ");
			}
			response.append(
					" Debit amount " + payment.getDebitAmount().toPlainString() + " " + payment.getDebitCurrency());
			response.append(", Payment amount " + payment.getPaymentAmount().toPlainString() + " "
					+ payment.getPaymentCurrency());
		}
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(response.toString());
		return createSpeechResponse(speech, interactive);
	}

	private SpeechletResponse getRate(String baseCcy, String quotedCcy, boolean interactive) {
		PlainTextOutputSpeech answer = new PlainTextOutputSpeech();
		answer.setText(String.format("The current rate for %s %s is %s", baseCcy, quotedCcy,
				rateProvider
						.getPrice(ccyReconciler.reconcileCurrency(baseCcy), ccyReconciler.reconcileCurrency(quotedCcy))
						.toPlainString()));
		return createSpeechResponse(answer, interactive);
	}

	@Override
	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		// TODO Auto-generated method stub

	}

}
