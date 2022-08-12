package com.codingdojo.mvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{
	List<Doctor> findAll();
//	@Query(value="SELECT count(*) from doctors", nativeQuery=true)
	

	Optional<Doctor> findByEmail(String email);
}
