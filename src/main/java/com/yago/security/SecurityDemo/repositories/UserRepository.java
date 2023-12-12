package com.yago.security.SecurityDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.yago.security.SecurityDemo.domain.user.User;

public interface UserRepository extends JpaRepository<User, String>{

	UserDetails findByLogin(String login);
	
}
