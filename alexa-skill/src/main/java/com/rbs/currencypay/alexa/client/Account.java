package com.rbs.currencypay.alexa.client;

import java.math.BigDecimal;

public class Account {

	private String customerId;
	private String id;
	private String name;
	private String sortCode;
	private String accountNo;
	private BigDecimal balance;
	private String currencyCode;
	private Currency currency;
	public boolean virtual;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getSortCode() {
		return sortCode;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
		this.currencyCode = currency != null ? currency.getCode() : "";
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public boolean isVirtual() {
		return virtual;
	}

	public void setVirtual(boolean virtual) {
		this.virtual = virtual;
	}
}
