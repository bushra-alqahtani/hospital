package com.codingdojo.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.model.Appointment;


@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	
	List<Appointment> findAll();
	
	
	
}
