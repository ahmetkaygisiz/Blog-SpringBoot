package com.blog.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.domain.Category;
import com.blog.domain.Post;
import com.blog.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping("/index")
	public String post() {
		return "";
	}
	
	@RequestMapping("/create")
	public String createPost(Model model) {
		Post post = new Post();
		
		Set<Category> categories = postService.getCategories();
		
		model.addAttribute("categories",categories);
		model.addAttribute("post",post);
		return "post-create";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPost() {
		return "post-edit";
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePost() {
		return "post-delete";
	}
	
	@RequestMapping()
	public String listPost() {
		return "postList";
	}
}
