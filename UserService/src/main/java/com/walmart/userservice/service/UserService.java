package com.walmart.userservice.service;

import com.walmart.userservice.dto.UserDTO;
import com.walmart.userservice.exception.UserNotFoundException;

public interface UserService {
	
	UserDTO registerUser(UserDTO userDto);
	UserDTO getUserByUsername(String username) throws UserNotFoundException;
	Double getUserBalance(String username) throws UserNotFoundException;
	boolean updateUserBalance(String username, Double newBalance);

}
