package com.store;

public class Order {

	private int orderId;
	private String customerName;
	private float orderAmount;
	private String paymentOption;
	
	// Constructor to initialize order details, throws InvalidOrderException for invalid inputs
	public Order(int orderId, String customerName, float orderAmount, String paymentOption)
			throws InvalidOrderException {
		// Validate orderAmount; it should not be less than 100
		if (orderAmount < 100) {
			throw new InvalidOrderException("orderAmount should not be less than 100");
		}
		// Validate paymentOption; it can be either “CoD” or “Gift Card” or “Internet Banking”
		if (!isValidPaymentOption(paymentOption)) {

			throw new InvalidOrderException("paymentOption can be either “CoD” or “Gift Card” or “Internet Banking");
		}

		this.orderId = orderId;
		this.customerName = customerName;
		this.orderAmount = orderAmount;
		this.paymentOption = paymentOption;
	}

	private boolean isValidPaymentOption(String paymentOption) {

		return (paymentOption.equals("CoD") || paymentOption.equals("Gift Card")
				|| paymentOption.equals("Internet Banking"));

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", orderAmount=" + orderAmount
				+ ", paymentOption=" + paymentOption + "]";
	}

}
