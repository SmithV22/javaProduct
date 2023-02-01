package com.smithv.neiajava.controllers;

import java.util.Arrays;
import java.util.List;

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

import com.smithv.neiajava.models.Address;
import com.smithv.neiajava.models.Customer;
import com.smithv.neiajava.services.AddressService;
import com.smithv.neiajava.services.CustomerService;
import com.smithv.neiajava.services.UserService;


@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressServ ;
	
	@Autowired
	private UserService userServ ;
	
	@Autowired
	private CustomerService customerServ ;
	
	@GetMapping("/add/{id}")
	public String add(@ModelAttribute("address") Address address, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/" ;
		}
		model.addAttribute("user", userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("customer", customerServ.getOne(id)) ;
		
		return "/address/newAddress.jsp" ;
	}
	
	@PostMapping("/add")
	public String addAddress(@Valid @ModelAttribute("address") Address address, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/address/newAddress.jsp" ;
		} else {
			
			addressServ.create(address) ;
			return "redirect:/customer/custDash" ;
		}
	}
	
	@GetMapping("/edit/{id}")
public String edit(Model model, @PathVariable("id") Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/custDash" ;
		}
		model.addAttribute("user", this.userServ.find((Long)session.getAttribute("userId"))) ;
		model.addAttribute("address", addressServ.getOne(id)) ;
	return "address/editAddress.jsp" ;
	}
	
	@PutMapping("/edit")
	public String update(@Valid @ModelAttribute("address") Address address, BindingResult result) {

		if(result.hasErrors()) {
			return "address/editAddress.jsp" ;
		} else {
			Address edittedAddress = addressServ.edit(address) ;
			return "redirect:/customer/custDash" ;
		}
	}
	
	
			
	
}
