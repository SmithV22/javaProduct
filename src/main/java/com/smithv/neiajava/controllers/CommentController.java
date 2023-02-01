package com.smithv.neiajava.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smithv.neiajava.models.Comment;
import com.smithv.neiajava.models.Project;
import com.smithv.neiajava.services.CommentService;
import com.smithv.neiajava.services.ProjectService;
import com.smithv.neiajava.services.UserService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentServ ;
	
	@Autowired
	private UserService userServ ;
	
	@Autowired
	private ProjectService projectServ ;
	
	@GetMapping("/comment/add/{id}")
	public String newComment(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/dashboard" ;
		}
		model.addAttribute("user", userServ.find((Long)session.getAttribute("userId"))) ;
		
		Long userId = (Long) session.getAttribute("userId") ;
		Project project = projectServ.getOne(id) ;
		model.addAttribute("comment", new Comment()) ;
		model.addAttribute("project", project) ;
		
		return "comment/newComment.jsp" ;
	}
	
	@PostMapping("/addComment/{id}")
public String addComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, HttpSession session, @PathVariable("id") Long id) {
		
		if(result.hasErrors()) {
			return "comment/newComment.jsp" ;
		} else {
			Long userId = (Long) session.getAttribute("userId") ;
			comment.setUser(userServ.find(userId)) ;
			comment.setProject(projectServ.getOne(id)) ;
			Project project = projectServ.getOne(id) ;
			project.getComments().add(comment) ;
		
			commentServ.create(comment) ;
			return "redirect:/project/project" + id  ;
		}
	}
	
}
