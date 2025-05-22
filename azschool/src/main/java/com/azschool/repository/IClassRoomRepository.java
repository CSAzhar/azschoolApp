package com.azschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azschool.entity.ClassRoom;

@Repository
public interface IClassRoomRepository extends JpaRepository<ClassRoom, Long>{

}
