package com.store.test;

import java.util.ArrayList;

import com.store.InvalidOrderException;
import com.store.Order;
import com.store.OrderServiceUtil;

public class TestClient {

	public static void main(String[] args) {

		OrderServiceUtil orderServiceUtil = new OrderServiceUtil();
		
		

		// add orders
		try {

			Order o1 = new Order(1001, "Sathish P H", 100, "CoD");
			Order o2 = new Order(1002, "Vijay", 200, "Gift Card");
			Order o3 = new Order(1003, "Ajith", 300, "Internet Banking");

			orderServiceUtil.addOrder(o1);
			orderServiceUtil.addOrder(o2);
			orderServiceUtil.addOrder(o3);

		} catch (InvalidOrderException e) {
			System.out.println("Invalid Order: " + e.getMessage());

		}

		// Search Order
		Order order = orderServiceUtil.searchOrder("1001");
		if (order != null) {
			System.out.println("order found " + order);
		} else {
			System.out.println("order not found ");
		}

		// Total Amount
		System.out.println("total amount:" + orderServiceUtil.findTotal());

	}

}
