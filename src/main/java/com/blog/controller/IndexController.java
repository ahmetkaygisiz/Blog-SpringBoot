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
			
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		return "new_product";
	}
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String saveProduct(@ModelAttribute("product") Product product) {
//		service.save(product);
//		
//		return "redirect:/";
//	}
//	
//	@RequestMapping("/edit/{id}")
//	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
//		ModelAndView mav = new ModelAndView("edit_product");
//		
//		Product product = service.get(id);
//		mav.addObject("product", product);
//		
//		return mav;
//	}	
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteProduct(@PathVariable(name = "id") Long id) {
//		service.delete(id);
//		
//		return "redirect:/";
//	}
}
