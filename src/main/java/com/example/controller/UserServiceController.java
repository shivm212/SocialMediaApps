package com.example.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dao.UserDaoService;
import com.example.entity.User;
import com.example.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserServiceController {
	
	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userDaoService.getAllUser();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Integer id){
		Optional<User> user = userDaoService.getAllUser().stream().filter(e -> e.getId() == id).findFirst();
		if(!user.isPresent())
			throw new UserNotFoundException("User Not found");
		return user.get();
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return  ResponseEntity.created(location).build();
	}
}
