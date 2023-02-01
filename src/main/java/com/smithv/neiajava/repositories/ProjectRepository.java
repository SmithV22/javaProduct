package com.smithv.neiajava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithv.neiajava.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
		
	List<Project> findAll() ;
	
	@Query(value="SELECT * FROM projects WHERE customer_id = ?1", nativeQuery=true)
    List<Project> getCustomerProjects(Long id);
}
