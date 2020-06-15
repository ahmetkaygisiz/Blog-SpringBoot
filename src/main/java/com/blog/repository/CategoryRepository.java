package com.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.blog.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
