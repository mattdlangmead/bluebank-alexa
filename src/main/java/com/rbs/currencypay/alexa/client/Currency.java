package com.rbs.currencypay.alexa.client;

public class Currency {

	private String code;
	private String name;
	private int exponent;

	public Currency() {
	}

	public Currency(String code) {
		this.code = code;
	}

	/**
	 * Unique currency code as defined by ISO-4217
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Currency name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * The number of decimal places used to denote minor units; 2 for most currencies.
	 * 
	 * @return
	 */
	public int getExponent() {
		return exponent;
	}

	@Override
	public String toString() {
		return code;
	}
}
