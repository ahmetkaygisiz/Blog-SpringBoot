package com.blog.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String subtitle;
	private String body;
	
	@CreationTimestamp
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "post_categories", 
			  joinColumns = @JoinColumn(name = "post_id"), 
			  inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Category post_categories;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "user_posts", 
			  joinColumns = @JoinColumn(name = "post_id"), 
			  inverseJoinColumns = @JoinColumn(name = "user_id"))
	private User user_posts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Category getCategory() {
		return post_categories;
	}

	public void setCategory(Category post_categories) {
		this.post_categories = post_categories;
	}

	public User getAuthor() {
		return user_posts;
	}

	public void setAuthor(User author) {
		this.user_posts = author;
	}
}
