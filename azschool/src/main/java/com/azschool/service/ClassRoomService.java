package com.azschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azschool.dto.Response;
import com.azschool.entity.ClassRoom;
import com.azschool.entity.School;
import com.azschool.repository.IClassRoomRepository;
import com.azschool.repository.ISchoolRepository;

@Service
public class ClassRoomService {
	
	@Autowired
	private IClassRoomRepository classRepository;
	@Autowired
	private ISchoolRepository schoolRepository;
	
	public Response addRoom(String name, Short totalStudents, Long schoolId) {
		Response response = new Response();
		School school = schoolRepository.findById(schoolId).get();
		if(school != null) {
			
			ClassRoom classRoom = new ClassRoom();
			classRoom.setName(name);
			classRoom.setTotalStudents(totalStudents);
			classRoom.setSchool(school);
			
			classRepository.save(classRoom);
			
			response.setStatusCode(200);
			response.setMessage("successful");
			
			return response;
		}
		response.setStatusCode(500);
		response.setMessage("Failed to inset class");
		
		return response;
	}


}
