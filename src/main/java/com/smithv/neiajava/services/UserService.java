package com.smithv.neiajava.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.smithv.neiajava.models.Customer;
import com.smithv.neiajava.models.LoginUser;
import com.smithv.neiajava.models.User;
import com.smithv.neiajava.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo ;
	
	public User find(Long id) {
		 return userRepo.findById(id).orElse(null) ;
	}
	
	public User register(User user, BindingResult result) {
		User emailCheck = userRepo.findByEmail(user.getEmail()).orElse(null) ;
		
		if (emailCheck != null) {
			user.getEmail().trim();
			result.rejectValue("email", "unique", "Email is already is use") ;
		}
		
		if (!user.getPassword().equals(user.getConfirmPass())) {
			result.rejectValue("confirmPass", "matches", "Passwords do not match");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()) ;
		user.setPassword(hash);
		
		return userRepo.save(user) ;
	}
	
	public User auth(LoginUser logUser, BindingResult result) {
		User userInDb = userRepo.findByEmail(logUser.getEmail()).orElse(null) ;
		
		if (userInDb == null) {
			result.rejectValue("email", "exists", "Invalid login attempt" ) ;
			return null ;
		}
		
		if (!BCrypt.checkpw(logUser.getPassword(), userInDb.getPassword())) {
			result.rejectValue("email", "auth", "Invalid login attempt");
			return null ;
		}
		
		if (result.hasErrors()) {
			return null ;
		}
		
		return userInDb ;
	}
	
	
	
}
