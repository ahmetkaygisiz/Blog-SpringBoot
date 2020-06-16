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

import com.blog.domain.Category;
import com.blog.domain.Post;
import com.blog.domain.Role;
import com.blog.domain.User;
import com.blog.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/profile")
	public String profile() {
		
		return "user/profile";
	}
	
	@GetMapping("/create")
	public String createUser(Model model) {
		User user = new User();
		
		List<Role> roles = userService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("user", user);
		
		return "admin/user-create";
	}
	
	@PostMapping("/create")
	public String createUserPost(@ModelAttribute("user") User user) {
		
		if(user.getId() == null)
			userService.createUser(user);
		else
			userService.updateUser(user);
		
		return "redirect:/user/create";
	}
	
	@GetMapping("/list")
	public String listUser(Model model) {
		List<User> users = userService.userList();
		model.addAttribute("users", users);
		
		return "admin/user-list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name= "id") Long id) {
		userService.deleteUser(id);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Long id,Model model) {
		User user = userService.findById(id);
		
		List<Role> roles = userService.getRoles();
		
		model.addAttribute("roles",roles);
		model.addAttribute("user",user);
		
		return "admin/user-create";
	}
	
	@GetMapping("/postConfirm")
	public String postConfirm() {
		return "admin/post-confirm";
	}
}
