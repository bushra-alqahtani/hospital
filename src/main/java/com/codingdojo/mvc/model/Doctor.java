package com.codingdojo.mvc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="doctors")
public class Doctor {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 	
	 	private String name;
	 	private String major;
	 	@NotEmpty(message = "Please enter username")
		private String username;
		
		@Email
		@NotEmpty(message = "Please enter email address")
		private String email;
		private String docdesc;
		private String type;
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDocdesc() {
			return docdesc;
		}

		public void setDocdesc(String docdesc) {
			this.docdesc = docdesc;
		}

		private String password;
		
		@Transient
		private String confPassword;
	 	@OneToMany(mappedBy = "doctor")
	 	private List<Appointment> appointments;

		public Doctor() {
			
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMajor() {
			return major;
		}

		public void setMajor(String major) {
			this.major = major;
		}

		public List<Appointment> getAppointments() {
			return appointments;
		}

		public void setAppointments(List<Appointment> appointments) {
			this.appointments = appointments;
		}

		public Long getId() {
			return id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfPassword() {
			return confPassword;
		}

		public void setConfPassword(String confPassword) {
			this.confPassword = confPassword;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		
	 	
	 	
	    
}
