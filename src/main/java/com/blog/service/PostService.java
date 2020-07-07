package com.blog.service;

import java.util.List;

import com.blog.domain.Category;
import com.blog.domain.Post;

public interface PostService {
	public Post createPost(Post post);
	public Post findById(Long id);
	public void updatePost(Post post);
	public void deletePost(Long id);
	public List<Category> getCategories();
	public List<Post> postList();
	public List<Post> postPublishedList();
	public List<Post> getPostByUsername(String username);
	public List<Post> getPostsWithCategoryId(Long id);

}
