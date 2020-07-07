package com.blog.service;

import java.util.List;
import java.util.Set;

import com.blog.domain.Role;
import com.blog.domain.User;

public interface UserService {
	
	public void createUser(User user);
	public User findById(Long id);
	public User findByUsername(String username);
	public void updateUser(User user);
	public void deleteUser(Long id);
	public List<Role> getRoles();
	public List<User> userList();
}
