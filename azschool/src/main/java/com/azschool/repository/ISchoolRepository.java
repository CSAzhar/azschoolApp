package com.azschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azschool.entity.School;

@Repository
public interface ISchoolRepository extends JpaRepository<School, Long>{
	

}
