package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.model.Appointment;
import com.codingdojo.mvc.repository.AppointmentRepository;



@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepo;
	
	// returns all the Lang
	
	public List<Appointment> getAllAppointment(){
		return appointmentRepo.findAll();
	}
	
	// creates a Appointment
    public Appointment createAppointment(Appointment b) {
        return appointmentRepo.save(b);
    }
    
  //get Appointment by id 
    public Optional<Appointment> getAppointmentById(Long id) {
    	return appointmentRepo.findById(id);
    }
    
 // retrieves a Appointment 
    public Appointment findAppointment(Long id) {
       Optional<Appointment> optional = appointmentRepo.findById(id);
        if(optional.isPresent()) {
           return optional.get();
        } else {
            return null;
        }
    }
	
//    
//    //update Appointment
    public Appointment updateAppointment(Long id,Appointment b) {
    	Optional<Appointment> obtional=appointmentRepo.findById(id);
    	if(obtional.isPresent()) {
    		Appointment lang =obtional.get();
    		lang.setDate(b.getDate());
    		lang.setStats(true);
    		appointmentRepo.save(lang);
    	}
    	return null; 
    }
	
	
 //delete
    
    public boolean deleteAppointment(Long id) {
    	Appointment remove = findAppointment(id);
    	if(remove==null) {
    		return false;
    		}
    	appointmentRepo.delete(remove);
    	return true;
    }

	
}
