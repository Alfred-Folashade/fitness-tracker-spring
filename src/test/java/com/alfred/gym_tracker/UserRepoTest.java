package com.alfred.gym_tracker;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepoTest {
	
	@Autowired
	UserRepo userRepo;

	
	@Test
	public void testSaveUser() {
		User user = new User();
		user.setFirstName("John");
		User savedUser = userRepo.save(user);
		assertEquals("John", savedUser.getName());
	}
	
	@Test
	public void testGetUserById() {
		User user = new User();
		user.setFirstName("John");
		User savedUser = userRepo.save(user);
		
		Optional<User> userFound = userRepo.findById(savedUser.getId());
		assertTrue(userFound.isPresent());
	}
	
	
}
