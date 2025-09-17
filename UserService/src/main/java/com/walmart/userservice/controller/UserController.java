package com.walmart.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.userservice.dto.UserDTO;
import com.walmart.userservice.exception.UserNotFoundException;
import com.walmart.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/welcome")
	public ResponseEntity<String> hello() {

		return new ResponseEntity<>("This endpoint is not secure", HttpStatus.CREATED);

	}

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO user) {

		userService.registerUser(user);
		return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);

	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/{username}")
	public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) throws UserNotFoundException {

		UserDTO userDto = userService.getUserByUsername(username);

		if (userDto != null) {
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/{username}/balance")
	public ResponseEntity<Double> getUserBalance(@PathVariable String username) throws UserNotFoundException {

		Double balance = userService.getUserBalance(username);

		if (balance != null && balance != 0) {
			return new ResponseEntity<>(balance, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PutMapping("updatebalance/{username}/{balance}")
	public boolean updateUserBalance(@PathVariable String username, @PathVariable Double balance) {

		return userService.updateUserBalance(username, balance);

	}

}
