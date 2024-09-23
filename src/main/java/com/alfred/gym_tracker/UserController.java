package com.alfred.gym_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class UserController {
	@Autowired
	UserRepo userRepo;
	
	@GetMapping(value="/users")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping(value="/getUserById{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userRepo.findById(id);
	}
	
	
}
