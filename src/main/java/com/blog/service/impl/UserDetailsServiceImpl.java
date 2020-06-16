package com.blog.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.blog.domain.User;
import com.blog.repository.UserRepository;
import com.blog.service.CustomUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService{

	private final static Logger LOGGER = Logger.getLogger(UserDetailsServiceImpl.class.getName());
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		
		if(user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new CustomUserDetails(user);		
	}

}
