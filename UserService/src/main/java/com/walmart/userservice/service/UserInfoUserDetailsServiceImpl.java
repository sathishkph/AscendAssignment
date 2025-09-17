
package com.walmart.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.walmart.userservice.dto.UserInfoUserDetails;
import com.walmart.userservice.entity.User;
import com.walmart.userservice.jpa.UserRepository;

public class UserInfoUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByUserID(username);

		return user.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found" + username));

	}

}
