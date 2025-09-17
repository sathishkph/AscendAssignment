package com.walmart.transaction.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.walmart.transaction.entity.Transaction;
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
	 List<Transaction> findByTransactionType(String transactionType);

}
