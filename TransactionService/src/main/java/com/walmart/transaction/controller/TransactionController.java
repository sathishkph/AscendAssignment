package com.walmart.transaction.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.transaction.dto.TransactionDTO;
import com.walmart.transaction.exception.InsufficientBalanceException;
import com.walmart.transaction.service.TransactionServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionservice;

	@PostMapping("/add")
	public ResponseEntity<String> registerTransaction(@Valid @RequestBody TransactionDTO transactionDto,
			@RequestHeader HttpHeaders headers) throws InsufficientBalanceException, AccessDeniedException {

		transactionservice.registerTransaction(transactionDto, headers);
		return new ResponseEntity<>("Transaction made successfully", HttpStatus.CREATED);
	}

}
