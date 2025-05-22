package com.azschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azschool.dto.Response;
import com.azschool.service.ClassRoomService;

import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/class")
@CrossOrigin
public class ClassRoomController {
	
	@Autowired
	private ClassRoomService service;
	
	@PostMapping("/add-class")
	public ResponseEntity<Response> addClassRoom(@RequestParam String name, 
												 @RequestParam Short totalStudents,
												 @RequestParam Long id
												){
		Response res =  service.addRoom(name, totalStudents, id);
		return ResponseEntity.status(res.getStatusCode()).body(res);
		
	}
	

}
