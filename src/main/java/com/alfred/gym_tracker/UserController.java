package com.alfred.gym_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Controller
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
	public String saveUser(@ModelAttribute("newUser") User user) {
		userService.saveUser(user);
		return "index";
	}
	
	@GetMapping(value="/registerNew")
	public String registerNew(Model model) {
		User user = new User();
		model.addAttribute("newUser", user);
		return "Registration";
	}
	
	@GetMapping(value="/login")
	public String loginNew() {
		return "login";
	}
	
	@GetMapping("/index")
    public String index() {
        return "index";  // This corresponds to a view named 'index.html' or a route
    }
	
}
