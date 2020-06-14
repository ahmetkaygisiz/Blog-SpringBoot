package com.blog.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.repository.UserRepository;

@Controller
public class IndexController {
	
	Logger LOGGER = Logger.getLogger(IndexController.class.getName());
	
	@RequestMapping("/")
	public String viewIndexPage(Model model) {
		return "index";
	}
	
	@RequestMapping("/login")
	public String showNewProductForm(Model model) {
		return "login";
	}
}
