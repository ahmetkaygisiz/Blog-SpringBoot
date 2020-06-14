package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.domain.Role;
import com.blog.domain.User;
import com.blog.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/userCreate")
	public String createUser(Model model) {
		User user = new User();
		
		List<Role> roles = userService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("user", user);
		
		return "admin/user-create";
	}
	
	@PostMapping("/userCreate")
	public String createUserPost(Model model, @ModelAttribute("user") User user) {
		userService.createUser(user);
		
		List<Role> roles = userService.getRoles();
		model.addAttribute("roles", roles);
		user = new User();
		model.addAttribute("user", user);
		
		return "admin/user-create";
	}
	
	@GetMapping("/userList")
	public String listUser(Model model) {
		List<User> users = userService.userList();
		model.addAttribute("users", users);
		
		return "admin/user-list";
	}
	
	@RequestMapping("/userDelete/{id}")
	public String deleteUser(Model model, @PathVariable(name= "id") Long id) {
		List<User> users = userService.userList();
		model.addAttribute("users", users);
		
		userService.deleteUser(id);
		return "admin/user-list";
	}
	
	@GetMapping("/postConfirm")
	public String postConfirm() {
		return "admin/post-confirm";
	}
}
