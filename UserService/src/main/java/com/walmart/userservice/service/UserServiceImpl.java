package com.walmart.userservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.userservice.dto.UserDTO;
import com.walmart.userservice.entity.User;
import com.walmart.userservice.exception.UserNotFoundException;
import com.walmart.userservice.jpa.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ObjectMapper objectMapper;

	public UserDTO registerUser(UserDTO userDto) {

		// Password encoding before saving to DB

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

		User user = objectMapper.convertValue(userDto, User.class);

		return objectMapper.convertValue(userRepository.save(user), UserDTO.class);
	}

	public UserDTO getUserByUsername(String username) throws UserNotFoundException {

		Optional<User> user = userRepository.findByUserID(username);

		if (user.isPresent()) {

			return objectMapper.convertValue(user.get(), UserDTO.class);
		} else {
			log.info("No User Account for this Username {}", username);
			throw new UserNotFoundException("No User Account for this Username");
		}

	}

	public Double getUserBalance(String username) throws UserNotFoundException {

		return getUserByUsername(username).getBalance();

	}

	public boolean updateUserBalance(String username, Double newBalance) {
		try {
			userRepository.updateBalanceByUserID(username, newBalance);
			log.info("balance updated");
			return true;
		} catch (Exception e) {
			log.info("Balance update failed for this user ID {}", username);
			return false;
		}

	}
}
