package com.walmart.userservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {

	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "UserID must contain only alphanumeric characters")
	private String userID;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$", message = "Password must be at least eight characters long and contain at least one uppercase letter, one lowercase letter, and one number")
	private String password;

	@Email(message = "Please enter a valid email address")
	private String emailAddress;

	@Pattern(regexp = "^[a-zA-Z]+$", message = "firstName must contain only contain characters")
	private String firstName;

	@Pattern(regexp = "^[a-zA-Z]+$", message = "lastName must contain only contain characters")
	private String lastName;

	private Double balance;

	private String roles;

}
