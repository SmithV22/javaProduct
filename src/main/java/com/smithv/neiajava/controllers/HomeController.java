package com.smithv.neiajava.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smithv.neiajava.models.LoginUser;
import com.smithv.neiajava.models.User;
import com.smithv.neiajava.services.ProjectService;
import com.smithv.neiajava.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ ;
	
	@Autowired
	private ProjectService projectServ ;
	
		
	@GetMapping("/")
	public String loginPage(@ModelAttribute("loginUser") LoginUser logUser) {
		return "login.jsp" ;
	}
	
	@PostMapping("/")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser logUser, BindingResult result, HttpSession session) {
		User loggingIn = userServ.auth(logUser, result) ;
		
		if (result.hasErrors()) {
			System.out.println(result.hasErrors()) ;
			return "login.jsp" ;
		}
		
		session.setAttribute("userId", loggingIn.getId()) ;
		return "redirect:/dashboard" ;
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		
		return "register.jsp" ;
	}
	
	@PostMapping("/register") 
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session ) {
		
		User regUser = userServ.register(user, result) ;
		
		if (result.hasErrors()) {
			return "register.jsp" ;
		}
		
		session.setAttribute("userId", regUser.getId()) ;
		return "redirect:/dashboard" ;
	}
	
	
	@GetMapping("/dashboard") 
	public String dashboard(Model model, HttpSession session) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/" ;
		}
		model.addAttribute("user", userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("allProjects", this.projectServ.getAll()) ;
		return "/project/dashboard.jsp" ;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/" ;
	}
	
	
}
