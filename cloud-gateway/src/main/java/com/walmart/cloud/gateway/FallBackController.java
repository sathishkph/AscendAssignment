package com.walmart.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping("/userFallBack")
	public Mono<String> userServiceFallBack(){
		return Mono.just("User Service is taking too long to respond or is down,Please try again later");
		
	}
	
	@RequestMapping("/transactionFallBack")
	public Mono<String> transactionServiceFallBack(){
		return Mono.just("Transaction  Service is taking too long to respond or is down,Please try again later");
		
	}

}
