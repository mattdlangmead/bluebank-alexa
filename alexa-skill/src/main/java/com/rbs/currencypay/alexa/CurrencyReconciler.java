package com.rbs.currencypay.alexa;

import java.util.HashMap;
import java.util.Map;

public class CurrencyReconciler {

	private Map<String, String> currencies;

	public CurrencyReconciler() {
		currencies = new HashMap<>();
		currencies.put("sterling", "GBP");
		currencies.put("usdollar", "USD");
		currencies.put("dollar", "USD");
		currencies.put("us", "USD");
		currencies.put("yen", "JPY");
		currencies.put("euro", "EUR");
		currencies.put("canadian", "CAD");
		currencies.put("canadiandollar", "CAD");
		currencies.put("dollar", "USD");
		currencies.put("aussiedollar", "AUD");
		currencies.put("australian", "AUD");
		currencies.put("australiandollar", "AUD");
		currencies.put("japaneseyen", "JPY");
		currencies.put("swedishkroner", "SEK");
		currencies.put("norwegiankroner", "NOK");
		currencies.put("hongkongdollar", "HKD");
		currencies.put("hongkong", "HKD");
	}

	public String reconcileCurrency(String source) {
		if (source == null) {
			return null;
		}
		String strippedSource = source.trim().replace(" ", "").replace(".", "").toLowerCase();
		if (currencies.containsKey(strippedSource)) {
			return currencies.get(strippedSource);
		}
		return strippedSource;
	}
}
