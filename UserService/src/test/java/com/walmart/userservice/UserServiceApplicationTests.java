package com.walmart.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.userservice.dto.UserDTO;
import com.walmart.userservice.entity.User;
import com.walmart.userservice.exception.UserNotFoundException;
import com.walmart.userservice.jpa.UserRepository;
import com.walmart.userservice.service.UserServiceImpl;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private Validator validator;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testValidUser() {
		User user = new User("validUser123", "Password123", "test@example.com", "Sathish", "PH", 100.0, "USER");

		Errors errors = new BeanPropertyBindingResult(user, "user");
		validator.validate(user, errors);

		assertTrue(errors.getAllErrors().isEmpty());
	}

	@Test
	void testInvalidUserId() {
		User user = new User("invalid user", "Password123", "test@example.com", "Sathish", "PH", 100.0, "USER");

		Errors errors = new BeanPropertyBindingResult(user, "user");
		validator.validate(user, errors);

		assertEquals(1, errors.getErrorCount());
		assertEquals("UserID must contain only alphanumeric characters",
				errors.getAllErrors().get(0).getDefaultMessage());
	}

	@Test
	void testInvalidPassword() {
		User user = new User("validUser123", "weakpassword", "test@example.com", "Sathish", "PH", 100.0, "USER");

		Errors errors = new BeanPropertyBindingResult(user, "user");
		validator.validate(user, errors);

		assertEquals(1, errors.getErrorCount());
		assertEquals(
				"Password must be at least eight characters long and contain at least one uppercase letter, one lowercase letter, and one number",
				errors.getAllErrors().get(0).getDefaultMessage());
	}

	@Test
	void testRegisterUser() {
		UserDTO userDto = new UserDTO("validUser123", "Password123", "test@example.com", "Sathish", "PH", 100.0,
				"USER");
		User user = objectMapper.convertValue(userDto, User.class);

		when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
		when(userRepository.save(any(User.class))).thenReturn(user);

		verify(passwordEncoder, times(1)).encode("Password123");
		verify(userRepository, times(1)).save(any(User.class));
	}

	@Test
	void testGetUserByUsername() throws UserNotFoundException {
		UserDTO userDto = new UserDTO("existingUser", "Password123", "test@example.com", "Sathish", "PH", 100.0,
				"USER");
		User user = objectMapper.convertValue(userDto, User.class);
		when(userRepository.findByUserID("existingUser")).thenReturn(Optional.of(user));

		UserDTO retrievedUser = userService.getUserByUsername("existingUser");

		assertEquals(userDto, retrievedUser);
	}

	@Test
     void testGetUserByUsername_UserNotFoundException() {
        when(userRepository.findByUserID("nonexistentUser")).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.getUserByUsername("nonexistentUser"));
    }

	@Test
	void testGetUserBalance() throws UserNotFoundException {
		User user = new User("testUser", "Password123", "test@example.com", "Sathish", "PH", 100.0, "USER");
		when(userRepository.findByUserID("testUser")).thenReturn(Optional.of(user));

		Double balance = userService.getUserBalance("testUser");

		assertEquals(100.0, balance);
	}

	@Test
     void testGetUserBalance_UserNotFoundException() {
        when(userRepository.findByUserID("nonexistentUser")).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.getUserBalance("nonexistentUser"));
    }

}
