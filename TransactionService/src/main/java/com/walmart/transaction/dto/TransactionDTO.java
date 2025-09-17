package com.walmart.transaction.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

	@Min(value = 1, message = "Transaction amount must be positive number")
	private Double amount;
	@Pattern(regexp = "^(deposit|withdraw)$", message = "Transaction type must be 'deposit' or 'withdraw'")
	private String transactionType;

}
