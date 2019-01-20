package com.annujum.market.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annujum.market.model.Category;
import com.annujum.market.model.Product;
import com.annujum.market.repository.CategoryRepository;
import com.annujum.market.repository.ProductRepository;

@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8100", "http://localhost:8080", "http://192.168.227.1:8100", "http://192.168.227.1:8080" })
@RestController
@RequestMapping("products/")
public class ProductController {
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	private PageRequest gotoPage(int page) {
		PageRequest request = new PageRequest(page, 10); //PageRequest(page,1);
		        return request;
	}

	public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@GetMapping("{id}")
	public Product getProductById(@PathVariable("id") long id) {
		return productRepository.findById(id);
	}
	
	@GetMapping("list")
	public Collection<Product> getProducts() {
		return productRepository.findAll().stream().collect(Collectors.toList());
	}
	
	@GetMapping("listByCategory/{idCategory}")
	public Collection<Product> getProductsByCategory(@PathVariable("idCategory") long idCategory) {
		return productRepository.findByCategory_Id(idCategory).stream().collect(Collectors.toList());
	}
	
	@GetMapping("allCategories")
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll().stream().collect(Collectors.toList());
	}
	
	@GetMapping("list/{page}")
	public Collection<Product> getProductsPagines(@PathVariable("page") int page) {
		return productRepository.findAll(gotoPage(page)).stream().collect(Collectors.toList());
	}
	
	@GetMapping("listByCategoryPagined/{idCategory}/{page}")
	public Collection<Product> getProductsByCategoryPagined(@PathVariable("idCategory") long idCategory, @PathVariable("page") int page) {
		return productRepository.findByCategory_Id(idCategory, gotoPage(page)).stream().collect(Collectors.toList());
	}
	
	//Insertion de données
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		productRepository.save(product);
		
		return product;
	}
	
	@PutMapping("/update/{id}")
	public Product save(@PathVariable long id, @RequestBody Product product) {
		Product p = productRepository.findById(id);
		
		if(!product.getName().isEmpty()) {
			p.setName(product.getName());
		}
		
		if(!product.getDescription().isEmpty()) {
			p.setDescription(product.getDescription());
		}
		
		if(!product.getShortDescription().isEmpty()) {
			p.setShortDescription(product.getShortDescription());
		}
		
		p.setPrice(product.getPrice());
		
		if(!product.getPhoto().isEmpty()) {
			p.setPhoto(product.getPhoto());
		}
		
		if(!product.getVariety().isEmpty()) {
			p.setVariety(product.getVariety());
		}
		
		if(product.getCategory() != null) {
			p.setCategory(product.getCategory());
		}
		
		productRepository.save(p);
		
		return product;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		Product product = productRepository.findById(id);
		productRepository.delete(product);
		
		return "";
	}
}
