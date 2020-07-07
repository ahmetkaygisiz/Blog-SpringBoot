package com.blog.controller;

import java.util.List;
import java.util.logging.Logger;

import com.blog.domain.Category;
import com.blog.domain.Post;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.utility.EmailServiceImpl;

@Controller
public class IndexController {
	
	Logger LOGGER = Logger.getLogger(IndexController.class.getName());
	
	@Autowired
	EmailServiceImpl emailService;

	@Autowired
	PostService postService;

	@RequestMapping("/")
	public String viewIndexPage(Model model) {
		List<Post> postList = postService.postPublishedList();
		model.addAttribute("postList",postList);
		return "index";
	}
	
	@RequestMapping("/login")
	public String showNewProductForm(Model model) {
		return "login";
	}
	
	@RequestMapping("/about")
	public String aboutMe() {
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/category/{id}")
	public String category(@PathVariable("id") Long id, Model model) {
		List<Post> postList = postService.getPostsWithCategoryId(id);
		model.addAttribute("postList",postList);
		return "index";
	}

	@RequestMapping("/sendMail")
	public String contactMail() {
		emailService.sendSimpleMessage("ahmetkaygisiz17@gmail.com", "blog hkknda", "bu bir tekstir...");
		return "index";
	}

	@RequestMapping("/post/{id}")
	public String postShow(@PathVariable("id") Long id, Model model) {
		Post post = postService.findById(id);
		model.addAttribute("post",post);

		return "post";
	}

	@RequestMapping("/home/index")
	public String showHomePage() {
		return "home";
	}
}
