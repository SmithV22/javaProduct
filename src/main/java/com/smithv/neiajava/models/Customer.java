package com.smithv.neiajava.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank(message="Please enter First Name")
	@Size(max=15)
	private String firstName ;
	
	@NotBlank(message="Please enter Last Name")
	@Size(max=30)
	private String lastName ;
	
	@Email
	@NotBlank(message="Please enter a valid email")
	private String email ;
	
	@NotBlank
	@Pattern(regexp="((\\(\\d{3}\\)) ?|(\\d{3}-))?\\d{3}-\\d{4}", message="Please use format (111) 111-1111")
	private String phone ;
	
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
	
//  must add address 1 to 1.	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Address address;
	
	@OneToMany(mappedBy="customerProj", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Project> projects ;
	
	public Customer() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String fName) {
		this.firstName = fName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lName) {
		this.lastName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	
	
		
}
