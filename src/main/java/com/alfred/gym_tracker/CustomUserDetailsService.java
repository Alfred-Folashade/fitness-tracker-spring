package com.alfred.gym_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements  UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("This email does not belong to any user: "+email);
		}
		return org.springframework.security.core.userdetails.User.builder()
				.username(email)
				.password(user.getPassword())
				.build();
	}

}

