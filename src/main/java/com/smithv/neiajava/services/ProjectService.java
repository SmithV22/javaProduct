package com.smithv.neiajava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithv.neiajava.models.Project;
import com.smithv.neiajava.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo ;
	
	public Project getOne(Long id) {
		return projectRepo.findById(id).orElse(null) ;
	}
	
	public Project create(Project project) {
		return projectRepo.save(project) ;
	}
	
	public Project edit(Project project) {
		 return projectRepo.save(project) ;
	}
	
	public List<Project> getAll() {
		return projectRepo.findAll() ;
	}
	
	public List<Project> allCustomerProjects(Long customer_id) {
		return projectRepo.getCustomerProjects(customer_id);
	}
	
	public Project update(Project project)  {
		return projectRepo.save(project) ;
	}
}
