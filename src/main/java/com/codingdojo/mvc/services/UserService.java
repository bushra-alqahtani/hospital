package com.codingdojo.mvc.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mvc.model.User;
import com.codingdojo.mvc.repository.UserRepository;
import com.codingdojo.mvc.request.UserLogin;

@Service
public class UserService {
	
	public final UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	//Auth User Register
	
	public User createUser(User user,BindingResult bindingResult){
		Optional<User> opUser=userRepo.findByEmail(user.getEmail());
		
		//email 
		if(opUser.isPresent()) {
			bindingResult.rejectValue("email", "unique", "this email already exist");
		}
		//password match
		if(!user.getPassword().equals(user.getConfPassword())) {
			bindingResult.rejectValue("password", "matches", "password Do not matches");
		}
		if(bindingResult.hasErrors()) {
			return null;
		}else {
			
			//hash the passwords on db
			String hashed= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
			return userRepo.save(user);
		}
	}
		
		public User login(UserLogin userLogin, BindingResult result) {
	        if(result.hasErrors()) {
	            return null;
	        }
	        Optional<User> potentialUser = userRepo.findByEmail(userLogin.getEmail());
	        if(!potentialUser.isPresent()) {
	            result.rejectValue("email", "Unique", "Unknown email!");
	            return null;
	        }
	        User user = potentialUser.get();
	        if(!BCrypt.checkpw(userLogin.getPassword(), user.getPassword())) {
	            result.rejectValue("password", "Matches", "Invalid Password!");
	        }
	        if(result.hasErrors()) {
	            return null;
	        } else {
	            return user;
	        }
	    }
		//for get user by id 
		public User findUser(Long id) {
			Optional<User> optional =  userRepo.findById(id);
		    return optional.isPresent()?  optional.get() : null;
		}
		
		
		
}
