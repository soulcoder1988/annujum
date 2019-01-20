package com.annujum.market.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annujum.market.model.User;
import com.annujum.market.repository.UserRepository;

@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8100", "http://localhost:8080", "http://192.168.227.1:8100", "http://192.168.227.1:8080" })
@RestController
@RequestMapping("user/")
public class UserController {
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("users")
	public Collection<User> getAllUsers(){
		return userRepository.findAll().stream().collect(Collectors.toList());
	}
	
	@GetMapping("get/{idUser}")
	public User getUser(@PathVariable("idUser") long idUser){
		return userRepository.findById(idUser);
	}
}
