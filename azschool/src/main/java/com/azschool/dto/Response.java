package com.azschool.dto;

import java.util.List;
import com.azschool.entity.ClassRoom;
import com.azschool.entity.School;
import com.azschool.entity.Student;
import com.azschool.entity.Subject;
import com.azschool.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(content = Include.NON_NULL)
public class Response {
	
	private Integer statusCode;
	private String message;
	
	private String token;
	private String role;
	private String expirationTime;
	
	
	private School school;
	private List<School> schoolList;
	private List<ClassRoom> classRoomList;
	private List<Student> studentList;
	private List<Subject> subjectList;
	private List<Teacher> teacherList;
	
	

}
