package com.codingdojo.mvc.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.mvc.model.Appointment;
import com.codingdojo.mvc.model.Doctor;
import com.codingdojo.mvc.model.User;
import com.codingdojo.mvc.request.UserLogin;
import com.codingdojo.mvc.services.AppointmentService;
import com.codingdojo.mvc.services.DoctorService;
import com.codingdojo.mvc.services.UserService;


@Controller
public class MainController {
	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	DoctorService doctorService;
	@Autowired
	UserService userService;
	
//	@RequestMapping("/index")
//	public String index() {
//		return"test.jsp";
//	}
	@GetMapping("/")
	public String home() {
	
		return "index.jsp";
	}
	@RequestMapping("/index")
	public String appointment(HttpSession session, Model model) {
		if (session.getAttribute("user_id")==null) {
			return "redirect:/reg";
		}
		Long id= (Long) session.getAttribute("user_id");
	//	Long doctor_id= (Long) session.getAttribute("doctor_id");
		User user =userService.findUser(id);
//		Doctor doctor = doctorService.findDoctor(doctor_id);
		model.addAttribute("user", user);
		
		
		List<Doctor> allDoctor = doctorService.getAllDoctor();
		model.addAttribute("allDoctor", allDoctor);
		
//		List<Doctor> countDoctors=doctorService.count();
//		model.addAttribute("countDoctors",countDoctors);
		model.addAttribute("doctors", doctorService.getAllDoctor());

		List<Appointment> all = appointmentService.getAllAppointment();
		model.addAttribute("all", all);
//		if(user.getType().equals("User")) {
//			return"app.jsp";
//			
//		}
//		else if (doctor.getType().equals("Doctor")) {
//			System.out.println(doctor.getType());
//			return "doctors.jsp";
//		}
		return"app.jsp";
	}

	@PostMapping("/index")
	public String newBook(@Valid @ModelAttribute("appointment") Appointment appointment, Model model,HttpSession session) {
		if (session.getAttribute("user_id")==null) {
			return "redirect:/reg";
		}
//			System.out.println(doctor.getName());
			model.addAttribute("user", userService.findUser((Long) session.getAttribute("user_id")));
//			doctorService.getDoctorById(doctor.getId());
			appointmentService.createAppointment(appointment);

			//here where i started edit
			//model.addAttribute(doctorService.count();
			return String.format("redirect:/check/%s", appointment.getId());
//			
	}
	
	
	@GetMapping("/check/{appoId}")
	 public String newpage(@PathVariable("appoId")Long appoId, Model model,HttpSession session) {  
		// for Error checking i use @valid 
		if (session.getAttribute("user_id")==null) {
			return "redirect:/reg";
		}
		if(!model.containsAttribute("timee")) {
			model.addAttribute("timee" , new Appointment());
		}
		
			Appointment appo = appointmentService.findAppointment(appoId);
//			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.timee", result);

			model.addAttribute("appo", appo);
//			appointmentService.updateAppointment(appo.getId(), null);
			
			
	      	//appointmentService.createAppointment(appointment);
	          return "check.jsp";
	      
	  }
	
	@PutMapping("/checkTime/{id}/edit")
    public String updateBook(@Valid @ModelAttribute("timee") Appointment timee,BindingResult result,RedirectAttributes redirectAttributes,HttpSession session,
    		@PathVariable("id") Long id, Model model) {
		if (session.getAttribute("user_id")==null) {
			return "redirect:/reg";
		}
		else if(result.hasErrors()) {
			model.addAttribute("timee", timee);
			redirectAttributes.addFlashAttribute("timee", timee);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.timee", result);

			return "check.jsp";
		}
		
		
    	appointmentService.updateAppointment(id, timee);                   // update(id ,book);
    	redirectAttributes.addFlashAttribute("success" ,"appointment has been creaated");
    	return "redirect:/userAppo";
//    	return String.format("redirect:/check/%s", id);
    }
	
	
	@RequestMapping("/userAppo")
	public String userAppo(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
    		return "redirect:/index";
    	}
		Long id= (Long) session.getAttribute("user_id");
		User userid =userService.findUser(id);
		model.addAttribute("userid", userid);
		
		List<Appointment> all = appointmentService.getAllAppointment();
		model.addAttribute("all", all);
		
		
		return"user.jsp";
	}

	
//	@RequestMapping("/doctors")
//	public String showdoctors(Model model) {
//		model.addAttribute("doctors", doctorService.getAllDoctor());
//		return "doctors.jsp";
//	}
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id")Long id,HttpSession session) {
		if(session.getAttribute("user_id")== null) {
			return "redirect:/";
		}
		model.addAttribute("appointment", appointmentService.findAppointment(id));
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String updateApp(@Valid @ModelAttribute("appointment") Appointment appointment,@PathVariable("id")Long id, BindingResult result) {
		if(result.hasErrors()) 
			return "edit.jsp";
		
		else {
			System.out.println(id);
			appointmentService.updateAppointment(id,appointment);
			return "redirect:/userAppo";
		}
	}
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		appointmentService.deleteAppointment(id);
		return "redirect:/userAppo";
	}
}