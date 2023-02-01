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

import com.smithv.neiajava.models.Customer;
import com.smithv.neiajava.models.Project;
import com.smithv.neiajava.services.CustomerService;
import com.smithv.neiajava.services.ProjectService;
import com.smithv.neiajava.services.UserService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerServ ;
	
	@Autowired
	private UserService userServ ;
	
	@Autowired
	private ProjectService projectServ ;
	
	@GetMapping("/add")
	public String add(@ModelAttribute("customer") Customer customer, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/custDash" ;
		}
		
		model.addAttribute("user", userServ.find((Long)session.getAttribute("userId"))) ;
	
		return "customer/newCustomer.jsp" ;
	}
	
	@PostMapping("/add")
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		
		Customer newCustomer = customerServ.create(customer, result) ;
		
		if(result.hasErrors()) {
			return "customer/newCustomer.jsp" ;
		} else {
			
			return "redirect:/customer/custDash" ;
		}
	}
	
	@GetMapping("/custDash") 
	public String dashboard(Model model, HttpSession session) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/" ;
		}
		model.addAttribute("user", userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("allCustomers", this.customerServ.getAll()) ;
		return "customer/custDashboard.jsp" ;
	}
	
	
	@GetMapping("/details/{id}")
	public String custDetails(@ModelAttribute("project") Project project, @PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/" ;
		}
		
		model.addAttribute("user", this.userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("customer", customerServ.getOne(id)) ;
		model.addAttribute("allProjects", customerServ.getAll())
;		
	return "customer/customer.jsp" ;
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/custDash" ;
		}
		model.addAttribute("user", this.userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("customer", customerServ.getOne(id)) ;
	return "customer/editCustomer.jsp" ;
	}
	
	@PutMapping("/edit")
	public String update(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {

		if(result.hasErrors()) {
			return "customer/editCustomer.jsp" ;
		} else {
			Customer edittedCustomer = customerServ.edit(customer) ;
		return "redirect:/customer/custDash" ;
		}
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/customer/custDash";
		}
		
		model.addAttribute("user", this.userServ.find((Long)session.getAttribute("userId"))) ;
		customerServ.delete(id) ;
		return "redirect:/customer/custDash" ;
	}
	
}

