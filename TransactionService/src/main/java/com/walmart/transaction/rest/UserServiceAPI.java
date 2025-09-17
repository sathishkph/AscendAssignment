package com.walmart.transaction.rest;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserServiceAPI {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(UserServiceAPI.class);

	private static final String USER_SERVICE = "http://USER-SERVICE/user/";
	private static final String UPDATE_BALANCE_PATH = "updatebalance/{username}/{balance}";

	@CircuitBreaker(name = "TRANSACTION_SERVICE", fallbackMethod = "getUserServiceFallback")
	public Double getCurrentBalance(String userId, HttpHeaders headers) throws AccessDeniedException {

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.addAll(headers);

		HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);

		try {
			ResponseEntity<Double> response = restTemplate.exchange(USER_SERVICE + userId + "/balance", HttpMethod.GET,
					requestEntity, Double.class);

			if (response.getStatusCode() == HttpStatus.OK) {

				return response.getBody();
			} else {
				return 0.0;
			}
		} catch (HttpClientErrorException.Unauthorized unauthorizedException) {
			throw new AccessDeniedException("User doesn't have access to make this transaction");

		} 

	}

	@CircuitBreaker(name = "TRANSACTION_SERVICE", fallbackMethod = "userServiceFallBack")
	public boolean updateUserBalance(String userId, Double amount, String type, HttpHeaders headers)
			throws AccessDeniedException {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("username", userId);
		uriVariables.put("balance", String.valueOf(amount));

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.addAll(headers);

		HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);

		try {
			ResponseEntity<Boolean> response = restTemplate.exchange(USER_SERVICE + UPDATE_BALANCE_PATH, HttpMethod.PUT,
					requestEntity, Boolean.class, uriVariables);

			if (response.getStatusCode() == HttpStatus.OK) {

				return response.getBody() != null;
			} else {
				return false;
			}
		} catch (HttpClientErrorException.Unauthorized unauthorizedException) {
			log.info("unauthorizedException for this userid{}", userId);
			throw new AccessDeniedException("User doesn't have access to make this transaction");

		} 

	}

	// Fallback method for User service
	public ResponseEntity<String> getUserServiceFallback(String userId, Exception e) {

		log.info("User service is down userId: {}", userId);

		return new ResponseEntity<>("User service is down, pls try later ", HttpStatus.OK);
	}

}
