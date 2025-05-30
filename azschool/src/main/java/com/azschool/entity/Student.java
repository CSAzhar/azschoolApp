package com.azschool.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastName;
	private String email;
	private String password;
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "classRoom_id")
	private ClassRoom classRoom;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<FeeDetails> feeDetails;

}
