package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mvc.model.Doctor;
import com.codingdojo.mvc.model.User;
import com.codingdojo.mvc.repository.DoctorRepository;
import com.codingdojo.mvc.request.UserLogin;
@Service
public class DoctorService {
	@Autowired
	DoctorRepository doctorRepo;

//	public Doctor createDoctor(doctor user,BindingResult bindingResult){
//		Optional<User> opUser=userRepo.findByEmail(user.getEmail());
//		
//		//email 
//		if(opUser.isPresent()) {
//			bindingResult.rejectValue("email", "unique", "this email already exist");
//		}
//		//password match
//		if(!user.getPassword().equals(user.getConfPassword())) {
//			bindingResult.rejectValue("password", "matches", "password Do not matches");
//		}
//		if(bindingResult.hasErrors()) {
//			return null;
//		}else {
//			
//			//hash the passwords on db
//			String hashed= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//			user.setPassword(hashed);
//			return userRepo.save(user);
//		}
//	}
//		
//		public User login(UserLogin userLogin, BindingResult result) {
//	        if(result.hasErrors()) {
//	            return null;
//	        }
//	        Optional<User> potentialUser = userRepo.findByEmail(userLogin.getEmail());
//	        if(!potentialUser.isPresent()) {
//	            result.rejectValue("email", "Unique", "Unknown email!");
//	            return null;
//	        }
//	        User user = potentialUser.get();
//	        if(!BCrypt.checkpw(userLogin.getPassword(), user.getPassword())) {
//	            result.rejectValue("password", "Matches", "Invalid Password!");
//	        }
//	        if(result.hasErrors()) {
//	            return null;
//	        } else {
//	            return user;
//	        }
//	    }
	public List<Doctor> getAllDoctor(){
		return doctorRepo.findAll();
	}
	
	
	 //get Doctor by id 
    public Doctor getDoctorById(Long id) {
    	Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
 			if(optionalDoctor.isPresent()) {
 				return optionalDoctor.get();
 			}else {
 				return null;
 		}
    }
    
 // retrieves a Doctor 
    public Doctor findDoctor(Long id) {
       Optional<Doctor> optional = doctorRepo.findById(id);
        if(optional.isPresent()) {
           return optional.get();
        } else {
            return null;
        }
    }
    
//count the num of all doctors
//    public List<Doctor> count(){
//    	return doctorRepo.CountDoctor();
//    }

	public void checkAppoint( Doctor doctor) {
		Doctor chosenDoc = doctor;
		
		
	}

}
