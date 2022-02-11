package com.hcl.msi.noram2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msi.noram2.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select count(*) from User where email_address = :emailId and password = :password")
	int authenticateUser(String emailId, String password);

	@Query(value = "select username from User where email_address = :emailId and password = :password")
	String getUserName(String emailId, String password);
	
	@Query(value = "select u from User u where u.email_address = :emailId")
	User getUserName(String emailId);
	
}