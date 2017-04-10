package com.rbs.currencypay.alexa.client;

public class Recipient {

	private String id;

	private String owningCustomerBin;

	private String owningCustomer;
	private String name;
	private String iban;
	private String currencyCode;
	private Currency currency;
	private String defaultReferencePart1;
	private String defaultReferencePart2;
	private String email;
	private String phoneNo;
	private String countryCode;
	private String externalId;

	private String beneBank;
	private String nationalClearingCode;

	private String address;

	private boolean smsEnabled = false;
	private boolean emailEnabled = false;
	private boolean virtual = false;

	public Recipient() {
	}

	public Recipient(String owningCustomer, String name, String address, String iban, Currency ccy, boolean virtual) {
		this.owningCustomer = owningCustomer;
		this.name = name;
		this.address = address;
		this.iban = iban;
		this.currency = ccy;
		this.currencyCode = ccy.getCode();
		this.virtual = virtual;
	}

	/**
	 * Persistence identifier - read-only
	 */
	public String getId() {
		return id;
	}

	/**
	 * The BIN of the owning customer, i.e. the customer that created this
	 * recipient
	 * 
	 * @return
	 */
	public String getOwningCustomerBin() {
		return owningCustomerBin;
	}

	/**
	 * The owning customer, i.e. the customer that created this recipient
	 * 
	 * @return
	 */
	public String getOwningCustomer() {
		return owningCustomer;
	}

	public void setOwningCustomer(String owningCustomer) {
		this.owningCustomer = owningCustomer;
	}

	public String getName() {
		return name;
	}

	public String getIban() {
		return iban;
	}

	public Currency getCurrency() {
		return currency;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format(
				"Recipient [id=%s, customer bin=%s, name=%s, iban=%s, currency=%s, defaultReference1=%s, defaultReference2=%s, email=%s, phoneNo=%s]",
				id, owningCustomerBin, name, iban, currency, defaultReferencePart1, defaultReferencePart2, email,
				phoneNo);
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public boolean isSmsEnabled() {
		return smsEnabled;
	}

	public void setSmsEnabled(boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}

	public boolean isEmailEnabled() {
		return emailEnabled;
	}

	public void setEmailEnabled(boolean emailEnabled) {
		this.emailEnabled = emailEnabled;
	}

	public boolean isVirtual() {
		return virtual;
	}

	public void setVirtual(boolean virtual) {
		this.virtual = virtual;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Id on external system, e.g. CurrencyCloud, ProDirectory, etc
	 * 
	 * @return
	 */
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDefaultReferencePart1() {
		return defaultReferencePart1;
	}

	public void setDefaultReferencePart1(String defaultReferencePart1) {
		this.defaultReferencePart1 = defaultReferencePart1;
	}

	public String getDefaultReferencePart2() {
		return defaultReferencePart2;
	}

	public void setDefaultReferencePart2(String defaultReferencePart2) {
		this.defaultReferencePart2 = defaultReferencePart2;
	}

	public String getNationalClearingCode() {
		return nationalClearingCode;
	}

	public void setNationalClearingCode(String nationalClearingCode) {
		this.nationalClearingCode = nationalClearingCode;
	}

	public String getBeneBank() {
		return beneBank;
	}

	public void setBeneBank(String beneBank) {
		this.beneBank = beneBank;
	}
}
