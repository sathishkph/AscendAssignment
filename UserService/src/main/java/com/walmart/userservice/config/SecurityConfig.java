
package com.walmart.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.walmart.userservice.service.UserInfoUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	// Authentication

	@Bean
	public UserDetailsService userDetailsService() {

		return new UserInfoUserDetailsServiceImpl();
	}

	// Authorization

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(csrf -> csrf.disable())

				.authorizeHttpRequests(authorizeRequests -> authorizeRequests
						.requestMatchers("/user/welcome", "/user/add", "/swagger-ui/index.html.index", "/swagger-ui/**","/v2/api-docs", "/v3/api-docs", "webjars/**", "/configuration/ui",
								"/configuration/security", "/javainuse-openapi/**")
						.permitAll()

						.requestMatchers("/user/**").authenticated())
				.httpBasic(httpSecurityHttpBasicConfigurer -> {
				}).build();

	}

	// Encryption

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
