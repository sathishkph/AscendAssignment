package com.walmart.userservice.jpa;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import com.walmart.userservice.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	 Optional<User> findByUserID(String userID);
	 
	 @Query("{'userID': ?0}")
	 @Update("{ '$set' : { 'balance' : ?1 } }")
	  void updateBalanceByUserID(String userID, double balance);

	
	 
   
}

