package com.blog.controller;

import com.blog.domain.Category;
import com.blog.domain.Response;
import com.blog.domain.User;
import com.blog.repository.CategoryRepository;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class AjaxController {

	@Autowired
	CategoryRepository categoryRepository ;

	@Autowired
	UserService userService;

	@RequestMapping("/category/all")
	@ResponseBody
	public Response getCategories() {
		List<Category> categories = (List<Category>) categoryRepository.findAll();

		Response response = new Response("Success",categories);

		return response;
	}

	@RequestMapping(value ="/user/updatePassword")
	@ResponseBody
	public Response updatePassword(@RequestParam(value = "USERNAME", required = true) String username,
									@RequestParam(value = "O_PASSWORD", required = true) String oldPassword,
								    @RequestParam(value = "N_PASSWORD", required = true) String newPassword){

		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder(12);
		Response response = null;

		User user = userService.findByUsername(username);

		boolean checkPassword = bpe.matches(oldPassword,user.getPassword());

		if(checkPassword){
			user.setPassword(newPassword);

			userService.updateUser(user);
			response = new Response("Success");
		}else {
			response = new Response("Failed");
		}

		return response;
	}
}
