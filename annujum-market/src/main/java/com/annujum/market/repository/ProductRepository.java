package com.annujum.market.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.annujum.market.model.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findById(long id);
	
	@EntityGraph(attributePaths = "category")
	List<Product> findByCategory_Id(Long idCategory);
	
	@EntityGraph(attributePaths = "category")
	List<Product> findByCategory_Id(Long idCategory, Pageable pageRequest);
	//@Query("select distinct category from Product")
	//List<Category> findCategory();
	
}
