package com.azschool.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Short totalStudents;
	
	@ManyToOne
	@JsonIgnore
	private School school;
	
	@OneToMany(mappedBy = "classRoom")
	private List<Student> students;
	
	@OneToMany
	private List<Subject> subjects;
	
	

}
