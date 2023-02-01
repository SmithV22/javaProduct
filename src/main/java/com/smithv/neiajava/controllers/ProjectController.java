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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smithv.neiajava.models.Comment;
import com.smithv.neiajava.models.Customer;
import com.smithv.neiajava.models.Project;
import com.smithv.neiajava.services.CommentService;
import com.smithv.neiajava.services.CustomerService;
import com.smithv.neiajava.services.ProjectService;
import com.smithv.neiajava.services.UserService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private UserService userServ ;
	
	@Autowired
	private ProjectService projectServ ;
	
	@Autowired
	private CustomerService customerServ ;
	
	@Autowired
	private CommentService commentServ ;
	
	@GetMapping("/add/{id}")
	public String add(@ModelAttribute("project") Project project, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			
			return "redirect:/dashboard" ;
		}
		model.addAttribute("user", userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("customer", customerServ.getOne(id)) ;
		return "project/newProject.jsp" ;
	}
	
	@PostMapping("/add")
	public String addProject(@Valid @ModelAttribute("project") Project project, BindingResult result) {
		
		if(result.hasErrors()) {
			return "project/newProject.jsp" ;
		} else {
			projectServ.create(project) ;
			return "redirect:/dashboard" ;
		}
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/custDash" ;
		}
		model.addAttribute("user", this.userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("project", projectServ.getOne(id)) ;
	return "project/editProject.jsp" ;
	}
	
	@PutMapping("/edit")
	public String update(@Valid @ModelAttribute("project") Project project, BindingResult result) {

		if(result.hasErrors()) {
			return "project/editProject.jsp" ;
		} else {
			Project edittedProject = projectServ.edit(project) ;
		return "redirect:/dashboard" ;
		}
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("user", this.userServ.find((Long)session.getAttribute("userId"))) ;
		customerServ.delete(id) ;
		return "redirect:/dashboard" ;
	}
	
	@GetMapping("/details/{id}")
	public String custDetails(@ModelAttribute("project") Project project, @ModelAttribute("customer") Customer customer, @PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/" ;
		}
		
		model.addAttribute("user", this.userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("project", projectServ.getOne(id)) ;	
	return "project/project.jsp" ;
	}
	
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
	
	@PostMapping("/addComment/{projId}")
public String addComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, HttpSession session, @PathVariable("projId") Long projId) {
		
		if(result.hasErrors()) {
			return "comment/newComment.jsp" ;
		} else {
			Long userId = (Long) session.getAttribute("userId") ;
			comment.setUser(userServ.find(userId)) ;
			Project project = projectServ.getOne(projId) ;
			comment.setProject(projectServ.getOne(projId)) ;
			
			commentServ.create(comment) ;
			return "redirect:/dashboard"  ;
		}
	}
	
	

	
}
