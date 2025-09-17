package com.walmart.transaction.service;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpHeaders;

import com.walmart.transaction.dto.TransactionDTO;
import com.walmart.transaction.entity.Transaction;
import com.walmart.transaction.exception.InsufficientBalanceException;

public interface TransactionService {

	public Transaction registerTransaction(TransactionDTO transactionDto, HttpHeaders headers)
			throws InsufficientBalanceException, AccessDeniedException;

	public String getUserName(HttpHeaders headers);

	public boolean handleWithdraw(String username, double currentBalance, TransactionDTO transactionDto,
			HttpHeaders headers) throws AccessDeniedException, InsufficientBalanceException;

	public boolean handleDeposit(String username, double currentBalance, TransactionDTO transactionDto,
			HttpHeaders headers) throws AccessDeniedException;
}
