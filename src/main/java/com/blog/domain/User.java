package com.blog.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String username;
	
	@NotNull
	private String password;
	private String full_name;
	
	private boolean enabled;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(
			  name = "users_roles", 
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "user_posts")
	private List<Post> posts = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", full_name=" + full_name
				+ ", enabled=" + enabled + ", roles=" + roles + "]";
	}
}
