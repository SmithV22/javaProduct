package com.smithv.neiajava.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
	private String street ;
	
	@NotBlank 
	private String city ;
	
	@NotBlank 
	private String state ;
	
	@NotBlank
	private String zip ;
		
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
	
	// 1 to 1 with custome
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;
	
	public Address() {}
	
	public Address(@NotBlank String street, @NotBlank String city, @NotBlank String state, @NotBlank String zip,
			Customer customer) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.customer = customer;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
