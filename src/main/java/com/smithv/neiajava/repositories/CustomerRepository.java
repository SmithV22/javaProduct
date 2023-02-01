package com.smithv.neiajava.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithv.neiajava.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findAll() ;
	Boolean existsByPhone(String phone) ;
	Customer findByEmail(String email) ;
	Optional <Customer> findByPhone(String phone) ;
	
	
	
}
