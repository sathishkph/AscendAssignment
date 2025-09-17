package com.walmart.orderservice.controller;

import java.time.Instant;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@GetMapping("/101")
	public OrderResponse getSampleOrder101() {
		// Creating sample data
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(1001);
		orderResponse.setCartId(1);
		orderResponse.setUserId(101);
		orderResponse.setDateOfOrder(Date.from((Instant.parse("2023-12-01T10:00:00Z"))));
		orderResponse.setAmount(65.50);
		orderResponse.setModeOfPayment("Online");
		orderResponse.setPaymentStatus("successful");
		orderResponse.setDateOfDelivery(Date.from((Instant.parse("2023-12-11T10:00:00Z"))));
		orderResponse.setStatusOfOrder("Delivered");

		return orderResponse;
	}
	
	
	@GetMapping("/102")
	public OrderResponse getSampleOrder102() {
		// Creating sample data
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(2001);
		orderResponse.setCartId(2);
		orderResponse.setUserId(102);
		orderResponse.setDateOfOrder(Date.from((Instant.parse("2023-11-01T10:00:00Z"))));
		orderResponse.setAmount(10.99);
		orderResponse.setModeOfPayment("Online");
		orderResponse.setPaymentStatus("successful");
		orderResponse.setDateOfDelivery(Date.from((Instant.parse("2023-11-05T10:00:00Z"))));
		orderResponse.setStatusOfOrder("Delivered");

		return orderResponse;
	}
	
	@GetMapping("/103")
	public OrderResponse getSampleOrder103() {
		// Creating sample data
		OrderResponse orderResponse = new OrderResponse();
		

		return orderResponse;
	}
	
	@GetMapping("/104")
	public OrderResponse getSampleOrder104() {
		// Creating sample data
		OrderResponse orderResponse = new OrderResponse();
		

		return orderResponse;
	}
	
	@GetMapping("/105")
	public OrderResponse getSampleOrder105() {
		// Creating sample data
   OrderResponse orderResponse = new OrderResponse();
		
   orderResponse.setCartId(9);
		return orderResponse;

		
	}

}
