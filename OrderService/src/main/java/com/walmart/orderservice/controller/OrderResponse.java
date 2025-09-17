
package com.walmart.orderservice.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

	private Integer orderId;
	private Integer cartId;
	private Integer userId;
	private Date dateOfOrder;
	private double amount;
	private String modeOfPayment;
	private String paymentStatus;
	private Date dateOfDelivery;
	private String statusOfOrder;
	

}
