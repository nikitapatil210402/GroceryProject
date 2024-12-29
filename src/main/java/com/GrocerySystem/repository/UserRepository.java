package com.GrocerySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GrocerySystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	boolean existsByEmail(String username);
	User findByEmail(String email);
}