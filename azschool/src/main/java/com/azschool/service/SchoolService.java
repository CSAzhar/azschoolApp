package com.azschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azschool.dto.Response;
import com.azschool.entity.School;
import com.azschool.exception.SchoolNotFoundException;
import com.azschool.repository.ISchoolRepository;

@Service
public class SchoolService {
	
	@Autowired
	private ISchoolRepository schoolRepository;
	
	public Response saveSchool(School schoolReq) {
		Response response = new Response();
		
		try {
			schoolRepository.save(schoolReq);
			response.setStatusCode(200);
			response.setMessage("successsful");
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("Error saving schools "+e.getMessage());
		}
		return response;
	}
	
	
	public Response getAllSchools() {
		Response response = new Response();
		
		try {
			List<School> schoolList = schoolRepository.findAll();
			response.setStatusCode(200);
			response.setMessage("successful");
			response.setSchoolList(schoolList);
		}catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("Error fetching schools "+e.getMessage());
		}
		return response;
	}
	
	
	public Response getSchoolById(Long schoolId) {
		Response response = new Response();
		
		try {
			School school = schoolRepository.findById(schoolId).orElseThrow( ()
												-> new SchoolNotFoundException("school not available by id:"+schoolId) );
			response.setStatusCode(200);
			response.setMessage("successful");
			response.setSchool(school);
		}catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("Error fetching schools "+e.getMessage());
		}
		return response;
	}

}




























