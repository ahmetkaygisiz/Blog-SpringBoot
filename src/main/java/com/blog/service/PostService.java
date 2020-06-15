package com.blog.service;

import java.util.Set;

import com.blog.domain.Category;
import com.blog.domain.Post;

public interface PostService {
	public Post createPost(Post post);
	public Post findById(Long id);
	public void updatePost(Post user);
	public void deletePost(Long id);
	public Set<Category> getCategories();
	public Set<Post> postList();
}
