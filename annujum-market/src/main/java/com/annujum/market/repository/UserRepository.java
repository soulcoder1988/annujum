package com.annujum.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annujum.market.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findById(long id);
}
