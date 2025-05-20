package com.azschool.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String qualification;
	private String role;
	private String email;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;
	
	@ManyToMany
	@JoinTable(
			name = "teacher_subject",
			joinColumns = @JoinColumn(name = "teacher_id"),
			inverseJoinColumns = @JoinColumn(name = "subject_id")
			)
	private List<Subject> subjectList;
	
	@OneToMany(mappedBy = "teacher")
	private List<ClassRoom> classRoomList;


}
