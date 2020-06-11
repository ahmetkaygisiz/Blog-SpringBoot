package com.blog.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.blog.domain.User;

public interface UserRepository  extends CrudRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUsernameByUsername(@Param("username") String username);
}
