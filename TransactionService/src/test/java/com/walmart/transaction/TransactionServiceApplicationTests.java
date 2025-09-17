package com.walmart.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.nio.file.AccessDeniedException;
import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

import com.walmart.transaction.dto.TransactionDTO;
import com.walmart.transaction.entity.Transaction;
import com.walmart.transaction.exception.InsufficientBalanceException;
import com.walmart.transaction.repository.TransactionRepository;
import com.walmart.transaction.rest.UserServiceAPI;
import com.walmart.transaction.service.TransactionServiceImpl;

@SpringBootTest
class TransactionServiceApplicationTests {


    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private UserServiceAPI userServiceAPI;

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    void testRegisterTransactionWithdraw() throws InsufficientBalanceException, AccessDeniedException {
        // Arrange
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("username:password".getBytes()));

        TransactionDTO transactionDto = new TransactionDTO(50.0, "withdraw");
        double currentBalance = 100.0;

        // Mocking behavior for userServiceAPI.getCurrentBalance
        when(userServiceAPI.getCurrentBalance("username", headers)).thenReturn(currentBalance);

        // Mocking behavior for userServiceAPI.updateUserBalance
        when(userServiceAPI.updateUserBalance("username", 50.0, "withdraw", headers)).thenReturn(true);

        // Mocking behavior for transactionRepository.save
        when(transactionRepository.save(any(Transaction.class))).thenReturn(new Transaction("username", 50.0, "withdraw"));

        // Act
        Transaction result = transactionService.registerTransaction(transactionDto, headers);

        // Assert
        assertNotNull(result);
        assertEquals("withdraw", result.getTransactionType());
        assertEquals(50.0, result.getAmount());
    }

    @Test
    void testRegisterTransactionDeposit() throws InsufficientBalanceException, AccessDeniedException {
        // Arrange
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("username:password".getBytes()));

        TransactionDTO transactionDto = new TransactionDTO(50.0, "deposit");
        double currentBalance = 100.0;

        // Mocking behavior for userServiceAPI.getCurrentBalance
        when(userServiceAPI.getCurrentBalance("username", headers)).thenReturn(currentBalance);

        // Mocking behavior for userServiceAPI.updateUserBalance
        when(userServiceAPI.updateUserBalance("username", 150.0, "deposit", headers)).thenReturn(true);

        // Mocking behavior for transactionRepository.save
        when(transactionRepository.save(any(Transaction.class))).thenReturn(new Transaction("username", 50.0, "deposit"));

        // Act
        Transaction result = transactionService.registerTransaction(transactionDto, headers);

        // Assert
        assertNotNull(result);
        assertEquals("deposit", result.getTransactionType());
        assertEquals(50.0, result.getAmount());
    }

    @Test
    void testRegisterTransactionInsufficientBalance() throws AccessDeniedException {
        // Arrange
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("username:password".getBytes()));

        TransactionDTO transactionDto = new TransactionDTO(150.0, "withdraw");
        double currentBalance = 100.0;

        // Mocking behavior for userServiceAPI.getCurrentBalance
        when(userServiceAPI.getCurrentBalance("username", headers)).thenReturn(currentBalance);

        // Act and Assert
        assertThrows(InsufficientBalanceException.class, () -> {
            transactionService.registerTransaction(transactionDto, headers);
        });
    }

    @Test
    void testRegisterTransactionAccessDenied() {
        // Arrange
        HttpHeaders headers = new HttpHeaders();

        // Act and Assert
        assertThrows(AccessDeniedException.class, () -> {
            transactionService.registerTransaction(new TransactionDTO(), headers);
        });
    }

}
