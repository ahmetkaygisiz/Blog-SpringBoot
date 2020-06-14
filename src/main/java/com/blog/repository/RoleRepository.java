package com.blog.repository;


import org.springframework.data.repository.CrudRepository;

import com.blog.domain.Role;

public interface RoleRepository  extends CrudRepository<Role, Long>{
	
}
