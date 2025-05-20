package com.azschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/all")
	public ResponseEntity<Response> getAllSchool(){
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
