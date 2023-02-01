package com.smithv.neiajava.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;
	
	@NotEmpty
	private String text ;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdAt ;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatedAt ;

	@PrePersist
	protected void OnCreate() {
		this.createdAt = new Date() ;
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date() ;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project ;
	
	public Comment() {}
	
	public Comment(Long id, @NotEmpty String text, Date createdAt, User user, Project project) {
		super();
		Id = id;
		this.text = text;
		this.createdAt = createdAt;
		this.user = user;
		this.project = project;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
	
}
