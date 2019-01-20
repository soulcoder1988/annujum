package com.annujum.market;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.annujum.market.model.Category;
import com.annujum.market.model.Product;
import com.annujum.market.model.User;
import com.annujum.market.repository.CategoryRepository;
import com.annujum.market.repository.ProductRepository;
import com.annujum.market.repository.UserRepository;

@SpringBootApplication
public class AnnujumMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnujumMarketApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
	        return args -> {
	        	//Category
	        	Category c1 = new Category();
	        	c1.setCode("C1");
	        	c1.setName("categorie1");
	        	c1.setDescription("Categorie 1");
	        	c1.setIconPhoto("1.jpg");
	        	
	        	Category c2 = new Category();
	        	c2.setCode("C2");
	        	c2.setName("categorie2");
	        	c2.setDescription("Categorie 2");
	        	c2.setIconPhoto("2.jpg");
	        	
	        	//Product
	        	Product p1 = new Product();
	        	p1.setName("nom1");
	        	p1.setDescription("Produit 1 Categorie 1 Variété 1");
	        	p1.setShortDescription("Produit 1 Categorie 1 Variété 1");
	        	p1.setCategory(c1);
	        	//c1.getProducts().add(p1);
	        	p1.setVariety("variete1");
	        	p1.setPrice(20);
	        	p1.setPhoto("1.jpg");
	        	
	        	Product p2 = new Product();
	        	p2.setName("nom2");
	        	p2.setDescription("Produit 2 Categorie 2 Variété 2");
	        	p2.setShortDescription("Produit 2 Categorie 2 Variété 2");
	        	p2.setCategory(c2);
	        	//c2.getProducts().add(p2);
	        	p2.setVariety("variete2");
	        	p2.setPrice(40);
	        	p2.setPhoto("2.jpg");
	        	
	        	//User
	        	User user1 = new User();
	        	user1.setLast_name("SOW");
	        	user1.setFirst_name("Oumar");
	        	user1.setUsername("osow");
	        	user1.setEmail("oumarsow@gmail.com");
	        	user1.setPassword("987654321");
	        	user1.setConfirm_password("987654321");
	        	
	        	User user2 = new User();
	        	user2.setLast_name("SOW");
	        	user2.setFirst_name("Ibrahima Sory");
	        	user2.setUsername("issow");
	        	user2.setEmail("ibrahimasorysow.88@gmail.com");
	        	user2.setPassword("123456789");
	        	user2.setConfirm_password("123456789");
	        	
	            Stream.of(p1, p2).forEach(p -> {
	            	categoryRepository.save(p.getCategory());
	            	productRepository.save(p);
	            });
	            
	            Stream.of(user1, user2).forEach(u -> {
	            	userRepository.save(u);
	            });
//	            categoryRepository.findAll().forEach(System.out::println);
//	            productRepository.findAll().forEach(System.out::println);
	        };
	}
}
