package com.azschool.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class FeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private Double amount;
	private LocalDate dueDate;
	private Boolean paid;
	private LocalDate paidDate;
	private Integer paymentYear;
	private Integer paymentMonth;
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	

}
