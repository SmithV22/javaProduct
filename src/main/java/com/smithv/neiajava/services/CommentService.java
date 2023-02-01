package com.smithv.neiajava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithv.neiajava.models.Comment;
import com.smithv.neiajava.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepo ;
	
	public Comment getOne(Long id) {
		return commentRepo.findById(id).orElse(null) ;
	}
	
	public Comment create(Comment comment) {
		return commentRepo.save(comment) ;
	}
	
	public Comment edit(Comment comment) {
		 return commentRepo.save(comment) ;
	}
	
	public List<Comment> getAll() {
		return commentRepo.findAll() ;
	}
	
		
}
