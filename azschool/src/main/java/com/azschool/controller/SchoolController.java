package com.azschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azschool.dto.Response;
import com.azschool.entity.School;
import com.azschool.service.SchoolService;

@RestController
@RequestMapping("/school")
@CrossOrigin
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);
	
	@GetMapping("/all")
	public ResponseEntity<Response> getAllSchool(){
		logger.info("inside getting school controller and getting all schools");
		Response response = schoolService.getAllSchools();
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Response> addSchool(@RequestBody School school){
		Response response = schoolService.saveSchool(school);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	@GetMapping("/get-room-by-id/{roomId}")
	public ResponseEntity<Response> findSchoolById(@PathVariable("roomId") Long id){
		Response response = schoolService.getSchoolById(id);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	
}
