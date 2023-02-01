package com.smithv.neiajava.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
	private String type ;
	
	@NotBlank
	private String description ;
	

	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal price ;
	
	@NotBlank
	private String completed ;
	
	@NotBlank
	private String sentToBilling ;
	
	@NotBlank
	@Size(max=8)
	private String paid ;
	
	private String assignedTo ;
	
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
	// 1 to many with user as Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customerProj ;
	
	@OneToMany(mappedBy="project", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	public Project() {}

	public Project(@NotBlank String type, @NotBlank String description, BigDecimal price, @NotBlank String completed,
			@NotBlank String sentToBilling, @NotBlank @Size(max = 8) String paid, String assignedTo) {
		super();
		this.type = type;
		this.description = description;
		this.price = price;
		this.completed = completed;
		this.sentToBilling = sentToBilling;
		this.paid = paid;
		this.assignedTo = assignedTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}
	
	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
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

	public Customer getCustomerProj() {
		return customerProj;
	}

	public void setCustomerProj(Customer customerProj) {
		this.customerProj = customerProj;
	}

	public String getSentToBilling() {
		return sentToBilling;
	}

	public void setSentToBilling(String sentToBilling) {
		this.sentToBilling = sentToBilling;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	
	
	
}
