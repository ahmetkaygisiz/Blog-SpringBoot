package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.blog.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long>{
	
	
	@Query("SELECT p FROM Post p "
			+ "WHERE p.user_posts.username = :username")
	public List<Post> getPostsByUsername(@Param("username") String username);
}
