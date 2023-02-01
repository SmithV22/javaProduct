package com.smithv.neiajava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.smithv.neiajava.models.Customer;
import com.smithv.neiajava.repositories.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo ;
	
	public Customer getOne(Long id) {
		return customerRepo.findById(id).orElse(null) ;
	}
	
	public Customer create(Customer customer, BindingResult result) {
		
		Customer phoneCheck = customerRepo.findByPhone(customer.getPhone()).orElse(null) ;
		if (phoneCheck != null) {
			result.rejectValue("phone", "unique", "Phone already exists") ;
		}
		if (result.hasErrors()) {
			return null;
		}
		
		return customerRepo.save(customer) ;
	}
	
	public Customer edit(Customer customer) {
		 return customerRepo.save(customer) ;
	}
	
	public Customer getCustomerByEmail(String email) {
		return customerRepo.findByEmail(email) ;
	}
	
	public void delete(Long id) {
		customerRepo.deleteById(id);
	}
	
	
	public List<Customer> getAll() {
		return customerRepo.findAll() ;
	}
	
		
	
}
