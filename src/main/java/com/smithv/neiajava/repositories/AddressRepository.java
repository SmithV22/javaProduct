package com.smithv.neiajava.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithv.neiajava.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
	List<Address> findAll() ;

	
}
