package com.example.StudentMan.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.StudentMan.data.entity.*;



@Repository
public interface StudentDao extends JpaRepository<Student,Integer>{

	public Student getByStudentName(String name);

    @Query("SELECT s.courses from Student s where s.studentName=:sn")
    public List<Course> getCourses(@Param("sn")String studentName);
	
	
	
}
