package com.example.StudentMan.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.StudentMan.data.entity.Course;
import com.example.StudentMan.data.entity.Enrollment;
import com.example.StudentMan.data.entity.Student;

@Repository
public interface EnrollmentDao extends JpaRepository<Enrollment,Integer> {

    @Query("SELECT e.grade FROM Enrollment e where e.student=:s and e.course=:c")
    public int getGradeByStudentAndCourse(@Param("s")Student student, @Param("c")Course course);

    @Query("SELECT e FROM Enrollment e where e.student=:s and e.course=:c")
    public Enrollment getEnrollment(@Param("s")Student student, @Param("c")Course course);
    @Query("SELECT e FROM Enrollment e where e.student=:s")
    public List<Enrollment> getEnrollments(@Param("s")Student student);


}