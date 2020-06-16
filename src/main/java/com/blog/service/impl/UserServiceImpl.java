package com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.domain.Role;
import com.blog.domain.User;
import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;
import com.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void createUser(User user) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder(12);
		user.setPassword(bpe.encode(user.getPassword()));
		
		userRepository.save(user);
	}

	@Override
	public List<User> userList() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void updateUser(User user) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder(12);
		User dbUser = userRepository.findById(user.getId()).get();
		
		dbUser.setUsername(user.getUsername());
		dbUser.setPassword(bpe.encode(user.getPassword()));
		dbUser.setRoles(user.getRoles());
		dbUser.setFull_name(user.getFull_name());
		dbUser.setEnabled(user.isEnabled());
		
		userRepository.save(dbUser);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<Role> getRoles() {
		return (List<Role>) roleRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

}
