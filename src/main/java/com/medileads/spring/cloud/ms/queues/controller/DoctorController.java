package com.medileads.spring.cloud.ms.queues.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medileads.spring.cloud.ms.queues.entity.Doctor;
import com.medileads.spring.cloud.ms.queues.entity.Doctorwidget;
import com.medileads.spring.cloud.ms.queues.service.DoctorService;



@Controller    
//@RequestMapping(path="/clinic") 
public class DoctorController {
	@Autowired 
	private DoctorService doctorservice;
	
	
	@GetMapping(path="/allDoctors")
	public @ResponseBody Iterable<Doctor> getAllDoctors() {
		return doctorservice.getAllDoctors();
	}
	
	@GetMapping(path="/getDoctorByName")
	public @ResponseBody List<Doctor> getDoctorByName(@RequestParam String firstName, @RequestParam String lastName) {
		System.out.println("firstName: "+firstName);
		return doctorservice.getDoctorByName(firstName, lastName);
	}
	
	@GetMapping(path="/getDoctorByEmail")
	public @ResponseBody List<Doctor> getDoctorByEmail(@RequestParam String email) {
		System.out.println("firstName: "+email);
		return doctorservice.getDoctorByEmail(email);
	}
	
	@GetMapping(path="/getDoctorsByClinic")
	public @ResponseBody List<Doctorwidget> getDoctorsByClinic(@RequestParam Integer id) {
		System.out.println("id: "+id);		
		return doctorservice.getDoctorsByClinic(id);
	}
}
