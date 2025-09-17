package com.walmart.transaction.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class Transaction {
	
	@NotEmpty(message = "Field cannot be empty")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "UserID must contain only alphanumeric characters")
	private String userID;
	
	@Min(value = 1 , message = "Transaction amount must be positive number")
	private Double amount;
	@Pattern(regexp = "^(deposit|withdraw)$", message = "Transaction type must be 'deposit' or 'withdraw'")
	private String transactionType;

}
