package com.annujum.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annujum.market.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
