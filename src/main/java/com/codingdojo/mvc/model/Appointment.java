package com.codingdojo.mvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "appointments")
public class Appointment {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descrition;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date date;

	private boolean stats;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="doctor_id", nullable=false)
	private Doctor doctor;
	
	 // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    //constructor

	public Appointment() {
		
	}


	public String getDescrition() {
		return descrition;
	}


	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	

	


	public boolean isStats() {
		return stats;
	}


	public void setStats(boolean stats) {
		this.stats = stats;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public Long getId() {
		return id;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	//getter
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
