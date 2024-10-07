package com.alfred.gym_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(value="/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping(value="/getUserById{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/updateById{id}")
	public void updateUserById(@PathVariable Long id, @RequestBody User user) {
		userService.updateUserById(id, user);
	}
	
	
	@DeleteMapping("/deleteUserById{id}")
	public void deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		
		
	}
	
	@PostMapping("/saveUser")
	public void saveUser(@RequestBody User newUser) {
		userService.saveUser(newUser);
	}
	
	
	
	
	
}
