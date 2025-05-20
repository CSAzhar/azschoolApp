package com.azschool.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String principal;
	private String photoUrl;
	private String address;
	private String email;
	private String password;
	private Integer isSchoolActive;
	
	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
	private List<ClassRoom> classRooms;

}
