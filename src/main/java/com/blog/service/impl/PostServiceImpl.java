package com.blog.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.domain.Category;
import com.blog.domain.Post;
import com.blog.repository.CategoryRepository;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post findById(Long id) {
		return postRepository.findById(id).get();
	}

	@Override
	public void updatePost(Post user) {
		
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}

	@Override
	public Set<Category> getCategories() {
		return (Set<Category>) categoryRepository.findAll();
	}

	@Override
	public Set<Post> postList() {
		return (Set<Post>) postRepository.findAll();
	}

}
