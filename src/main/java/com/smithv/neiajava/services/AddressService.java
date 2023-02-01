package com.smithv.neiajava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithv.neiajava.models.Address;
import com.smithv.neiajava.repositories.AddressRepository;


@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepo ;
	
	public Address getOne(Long id) {
		return this.addressRepo.findById(id).orElse(null) ;
	}
	
	public Address create(Address address) {
		return this.addressRepo.save(address) ;
	}
	
	public Address edit(Address address) {
		 return this.addressRepo.save(address) ;
	}
	
}
