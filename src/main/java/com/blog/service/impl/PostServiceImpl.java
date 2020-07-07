package com.blog.service.impl;

import java.util.Date;
import java.util.List;

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
	public void updatePost(Post post) {
		Post dbPost = postRepository.findById(post.getId()).get();
		
		dbPost.setTitle(post.getTitle());
		dbPost.setSubtitle(post.getSubtitle());
		dbPost.setBody(post.getBody());
		dbPost.setCategory(post.getCategory());
		dbPost.setAuthor(post.getAuthor());
		dbPost.setUpdated_at(new Date());
		dbPost.setPublished(post.isPublished());
		
		postRepository.save(dbPost);
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}

	@Override
	public List<Category> getCategories() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public List<Post> postList() {
		return (List<Post>) postRepository.findAll();
	}

	@Override
	public List<Post> postPublishedList() {
		return postRepository.postPublishedList();
	}

	@Override
	public List<Post> getPostByUsername(String username) {
		return (List<Post>) postRepository.getPostsByUsername(username);
	}

	@Override
	public List<Post> getPostsWithCategoryId(Long categoryId) {
		return (List<Post>) postRepository.getPostsWithCategoryId(categoryId);
	}
}
