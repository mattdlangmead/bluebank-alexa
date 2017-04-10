package com.rbs.currencypay.alexa.client;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Stores the information required to make a payment.
 * 
 * @author langmma
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentInstruction {

	private String id;

	private String trn;

	private String customer;

	private String debitAccountId;

	// private Account debitAccount;

	private String fxDealReference;

	private Recipient recipient;

	private BigDecimal paymentAmount;

	/**
	 * ISO currency code of payable (client buy) amount
	 */
	private String paymentCurrency;

	private BigDecimal debitAmount;

	/**
	 * ISO currency code of debit (client sell) amount
	 */
	private String debitCurrency;

	// private Priority priority;

	private String beneficiaryReference;

	private String customerReference;

	private Status status;

	// private LocalDate valueDate;

	// private DateTime created;
	/*
	 * public PaymentInstruction() { created = DateTime.now(); }
	 */
	public void setId(String id) {
		this.id = id;
	}

	public void setCustomerBin(String customer) {
		this.customer = customer;
	}

	/*
	 * public void setDebitAccount(Account debitAccount) { this.debitAccount =
	 * debitAccount; }
	 */
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public void setDebitCurrency(String debitCurrency) {
		this.debitCurrency = debitCurrency;
	}

	/*
	 * public void setPriority(Priority priority) { this.priority = priority; }
	 */
	public void setReference(String reference) {
		this.beneficiaryReference = reference;
	}

	public String getId() {
		return id;
	}

	public String getCustomer() {
		return customer;
	}

	public String getDebitAccountId() {
		return debitAccountId;
	}

	/*
	 * @JsonIgnore public Account getDebitAccount() { return debitAccount; }
	 * 
	 * public Recipient getRecipient() { return recipient; }
	 * 
	 * public void setRecipient(Recipient recipient) { this.recipient =
	 * recipient; }
	 */
	public Recipient getRecipient() {
		return recipient;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @return ISO currency code of payable (client buy) amount
	 */
	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public String getDebitCurrency() {
		return debitCurrency;
	}

	/*
	 * public Priority getPriority() { return priority; }
	 */
	public Status getStatus() {
		return status;
	}

	public void setBeneficiaryReference(String beneficiaryReference) {
		this.beneficiaryReference = beneficiaryReference;
	}

	public String getBeneficiaryReference() {
		return beneficiaryReference;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	/*
	 * public DateTime getCreated() { return created; }
	 * 
	 * public void setCreated(DateTime created) { this.created = created; }
	 * 
	 * public LocalDate getValueDate() { return valueDate; }
	 * 
	 * public void setValueDate(LocalDate valueDate) { this.valueDate =
	 * valueDate; }
	 */
	public String getFxDealReference() {
		return fxDealReference;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public static enum Priority {
		N("Normal"), U("Urgent"), L("Low value");

		private final String value;

		private Priority(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * Payment status
	 * 
	 * @author langmma
	 *
	 */
	public static enum Status {
		/**
		 * Awaiting booking of FX deal
		 */
		UNBOOKED,
		/**
		 * FX deal has been booked, but payment is pending authorisation
		 */
		AUTHORISED,
		/**
		 * payment completed
		 */
		SENT,
		/**
		 * Confirmation received - only applicable when pymt tracking is
		 * available
		 */
		CONFIRMED,
		/**
		 * Rejected by client at authorisation stage
		 */
		CANCELLED,
		/**
		 * Diarised payment for future non-interactive execution
		 */
		SCHEDULED,
		/**
		 * Failed, e.g. scheduled non-interactive payment
		 */
		FAILED,
		/**
		 * Payment requires 2FA before it can progress
		 */
		AWAITING_2FA,
		/**
		 * Payment has been returned after having been sent
		 */
		RETURNED;
	}
}
