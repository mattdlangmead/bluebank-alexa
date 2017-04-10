package com.rbs.currencypay.alexa;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public class Handler extends SpeechletRequestStreamHandler {

	private static final String APP_ID = "amzn1.ask.skill.b7395c5c-2a11-4257-ad91-879b16386083";

	private static final Set<String> supportedApplicationIds = new HashSet<>();
	static {
		supportedApplicationIds.add(APP_ID);
	}

	public Handler() {
		super(new CurrencyPaySpeechlet(), supportedApplicationIds);
	}

}
