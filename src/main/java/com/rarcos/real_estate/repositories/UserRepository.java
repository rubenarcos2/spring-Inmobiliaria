package com.rarcos.real_estate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rarcos.real_estate.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}