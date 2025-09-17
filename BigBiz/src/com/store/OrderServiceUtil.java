package com.store;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceUtil {

	private List<Order> orders = new ArrayList<>();

	public void addOrder(Order order) {

		orders.add(order);

	}

	// Method to search for an order by orderId
	public Order searchOrder(String orderId) {

		for (Order o : orders) {
			if (o.getOrderId() == Integer.valueOf(orderId)) {
				return o;

			}
		}

		return null;
	}
	// Method to calculate the total amount of all orders
	public float findTotal() {

		float totalAmount = 0;
		for (Order o : orders) {

			totalAmount += o.getOrderAmount();

		}
		return totalAmount;
	}

}
