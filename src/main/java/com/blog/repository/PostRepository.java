package com.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.blog.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

}
