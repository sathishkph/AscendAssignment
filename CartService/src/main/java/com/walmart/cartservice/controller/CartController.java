package com.walmart.cartservice.controller;


import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	@GetMapping("/fetchCartDetails/user/101")
	public CartResponse getSampleOrder101() {
		CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(1);
        cartResponse.setUserId(101);
        cartResponse.setAmount(65.50);

        // Sample ProductResponses
        List<ProductResponse> sampleProducts = Arrays.asList(
                new ProductResponse(101,  29),
                new ProductResponse(102, 39)
                // Add more products as needed
        );

        cartResponse.setProducts(sampleProducts);
        return cartResponse;

		
	}
	
	
	
	@GetMapping("/fetchCartDetails/user/102")
	public CartResponse getSampleOrder102() {
		// Creating sample data
		CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(2);
        cartResponse.setUserId(102);
        cartResponse.setAmount(10.99);

        // Sample ProductResponses
        List<ProductResponse> sampleProducts = Arrays.asList(
                new ProductResponse(104,  9),
                new ProductResponse(105, 6)
                // Add more products as needed
        );

        cartResponse.setProducts(sampleProducts);
        return cartResponse;
	}
	
	@GetMapping("/fetchCartDetails/user/104")
	public CartResponse getSampleOrder104() {
		// Creating sample data
		CartResponse cartResponse = new CartResponse();
		
		cartResponse.setCartId(4);
		cartResponse.setCartId(2);
        cartResponse.setUserId(102);
        cartResponse.setAmount(10.99);
		return cartResponse;
	}
	
	@GetMapping("/fetchCartDetails/user/103")
	public CartResponse getSampleOrder103() {
		

		return null;
	}
	
	@GetMapping("/fetchCartDetails/user/105")
	public CartResponse getSampleOrder105() {
		// Creating sample data
		CartResponse cartResponse = new CartResponse();
		
		cartResponse.setCartId(5);
		return cartResponse;
	}
}