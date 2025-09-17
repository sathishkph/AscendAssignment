package com.walmart.transaction.service;

import java.nio.file.AccessDeniedException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.walmart.transaction.dto.TransactionDTO;
import com.walmart.transaction.entity.Transaction;
import com.walmart.transaction.exception.InsufficientBalanceException;
import com.walmart.transaction.repository.TransactionRepository;
import com.walmart.transaction.rest.UserServiceAPI;

@Service
public class TransactionServiceImpl {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private UserServiceAPI userServiceAPI;

	private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

	public Transaction registerTransaction(TransactionDTO transactionDto, HttpHeaders headers)
			throws InsufficientBalanceException, AccessDeniedException {

		String username = getUserName(headers);

		boolean sucess = false;
		double currentBalance = userServiceAPI.getCurrentBalance(username, headers);

		log.info("getcurrent balance success");

		if (transactionDto.getTransactionType().equals("withdraw")) {

			sucess = handleWithdraw(username, currentBalance, transactionDto, headers);

		} else if (transactionDto.getTransactionType().equals("deposit")) {

			sucess = handleDeposit(username, currentBalance, transactionDto, headers);
		}

		if (sucess) {

			return transactionRepository
					.save(new Transaction(username, transactionDto.getAmount(), transactionDto.getTransactionType()));
		} else {
			return null;
		}
	}

	public String getUserName(HttpHeaders headers) throws AccessDeniedException {

		String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

		if (authorizationHeader != null) {
			String encodedCredentials = authorizationHeader.substring("Basic ".length()).trim();
			// Decode the Base64-encoded credentials
			String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));

			// Extract the username from the decoded credentials
			return decodedCredentials.split(":")[0];
		} else {
			throw new AccessDeniedException("User doesn't have access to make this transaction");
		}

	}

	public boolean handleWithdraw(String username, double currentBalance, TransactionDTO transactionDto,
			HttpHeaders headers) throws AccessDeniedException, InsufficientBalanceException {

		if (currentBalance > transactionDto.getAmount()) {

			return userServiceAPI.updateUserBalance(username, (currentBalance - transactionDto.getAmount()),
					transactionDto.getTransactionType(), headers);

		} else {
			throw new InsufficientBalanceException("Transaction Failed due to Insufficent Balance");
		}

	}

	public boolean handleDeposit(String username, double currentBalance, TransactionDTO transactionDto,
			HttpHeaders headers) throws AccessDeniedException {

		return userServiceAPI.updateUserBalance(username, (transactionDto.getAmount() + currentBalance),
				transactionDto.getTransactionType(), headers);

	}

}
