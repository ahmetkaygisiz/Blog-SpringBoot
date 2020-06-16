package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blog.domain.Category;
import com.blog.domain.Post;
import com.blog.service.PostService;
import com.blog.service.UserService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index")
	public String post() {
		return "";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		Post post = new Post();
		
		List<Category> categories = postService.getCategories();
		
		model.addAttribute("categories",categories);
		model.addAttribute("post",post);
		return "user/post-create";
	}
	
	@PostMapping("/create")
	public String createPost(Model model, 
							@ModelAttribute("post") Post post) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		post.setAuthor(userService.findByUsername(auth.getName()));
		
		if(post.getId() == null) 
			postService.createPost(post);
		else
			postService.updatePost(post);
		
		return "user/index";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model) {
		Post post = postService.findById(id);
		
		List<Category> categories = postService.getCategories();
		
		model.addAttribute("categories",categories);
		model.addAttribute("post",post);
		
		return "user/post-edit";
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePost(@PathVariable("id") Long id,Model model) {
		
		postService.deletePost(id);
		
		List<Post> posts = postService.postList();
		model.addAttribute("posts", posts);
		
		return "redirect:/post/list";
	}
	
	@RequestMapping("/list")
	public String listPost(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		boolean hasAdminRole = auth.getAuthorities()
								  .stream()
								  .anyMatch(r -> r.getAuthority().equals("ADMIN"));
		List<Post> posts ;
		
		if(hasAdminRole)
			posts = postService.postList();
		else {
			
			posts = postService.getPostByUsername(auth.getName());
			
			System.out.println("buradayim " + posts);
		}
			
		
		
		model.addAttribute("posts",posts);
		
		return "user/post-list";
	}
}
