package com.smithv.neiajava.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
	@Size(min=2, max=30)
	private String firstName ;
	
	@NotBlank
	@Size(min=2, max=30)
	private String lastName ;
	
	@NotBlank
	@Email
	@Size(min=2, max=50)
	private String email ;
	
	@NotBlank
	@Size(min=8, max=150)
	private String password ;
	
	@Transient
	private String confirmPass ;
	
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
	
	@OneToMany(mappedBy="customerProj", fetch=FetchType.LAZY)
	private List<Project> projects ;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Comment> comments ;
	
	public User() {}
	
	public User(@NotBlank @Size(min = 2, max = 30) String firstName, @NotBlank @Size(min = 2, max = 30) String lastName,
			@NotBlank @Email @Size(min = 2, max = 50) String email, @NotBlank @Size(min = 8, max = 150) String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPass() {
		return confirmPass ;
	}
	
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass ;
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
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComment(List<Comment> comments) {
		this.comments = comments;
	}


}
