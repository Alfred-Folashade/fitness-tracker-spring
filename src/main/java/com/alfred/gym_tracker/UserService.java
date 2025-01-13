package com.alfred.gym_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	
	
	private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}
	
	
	public void updateUserById(Long id, User user) {
		User updateUser = userRepo.findById(id).get();
		updateUser.setAge(user.getAge());
		//updateUser.setFirstName(user.getName());
		updateUser.setHeight(user.getHeight());
		updateUser.setWeight(user.getWeight());
		//updateUser.setBmi(user.getBmi());
		userRepo.save(updateUser);
	}
	
	
	
	public void deleteById(Long id) {
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		
		
	}
	
	
	public void saveUser(User newUser) {
		String normalPassword = newUser.getPassword();
		newUser.setPassword(encodePassword(normalPassword));
		userRepo.save(newUser);
	}
	
	
	
}
