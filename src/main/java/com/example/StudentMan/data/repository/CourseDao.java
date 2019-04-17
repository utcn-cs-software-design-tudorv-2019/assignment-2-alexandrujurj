package com.example.StudentMan.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentMan.data.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {

    public Course getByCourseName(String courseName);

}