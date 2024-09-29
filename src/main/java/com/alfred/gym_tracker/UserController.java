package com.alfred.gym_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
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
	
	@PostMapping("/updateById{id}")
	public void updateUserById(@PathVariable Long id, @RequestBody User user) {
		User updateUser = userRepo.findById(id).get();
		updateUser.setAge(user.getAge());
		updateUser.setFirstName(user.getName());
		updateUser.setHeight(user.getHeight());
		updateUser.setWeight(user.getWeight());
		updateUser.setBmi(user.getBmi());
		userRepo.save(updateUser);
	}
	
	
	@DeleteMapping("/deleteUserById{id}")
	public void deleteById(@PathVariable Long id) {
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		
		
	}
	
	@PostMapping("/saveUser")
	public void saveUser(@RequestBody User newUser) {
			userRepo.save(newUser);
	}
	
	
	
	
	
}
