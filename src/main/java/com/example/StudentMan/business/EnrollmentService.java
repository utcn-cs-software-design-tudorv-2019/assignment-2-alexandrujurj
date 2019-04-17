package com.example.StudentMan.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentMan.data.entity.Enrollment;
import com.example.StudentMan.data.entity.Student;
import com.example.StudentMan.data.repository.CourseDao;
import com.example.StudentMan.data.repository.EnrollmentDao;
import com.example.StudentMan.data.repository.StudentDao;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentRepository;

    @Autowired
    private StudentDao studentRepository;

    @Autowired
    private CourseDao courseRepository;

    public int getGrade(String studentName,String courseName)
    { return enrollmentRepository.getGradeByStudentAndCourse(studentRepository.getByStudentName(studentName),courseRepository.getByCourseName(courseName)); }

    public void setGrade(String studentName,String courseName,int grade)
    {
        Enrollment e=enrollmentRepository.getEnrollment(studentRepository.getByStudentName(studentName),courseRepository.getByCourseName(courseName));
        e.setGrade(grade);
        enrollmentRepository.save(e);
    }
    public List<Enrollment> getEnrollments(Student s)
    {
        return enrollmentRepository.getEnrollments(s);
    }

    public void createEnrollment(String nameStudent,String nameCourse)
    { enrollmentRepository.save(new Enrollment(studentRepository.getByStudentName(nameStudent),courseRepository.getByCourseName(nameCourse),0)); }

    public void deleteEnrollment(String nameStudent,String nameCourse)
    {   Enrollment e=enrollmentRepository.getEnrollment(studentRepository.getByStudentName(nameStudent),courseRepository.getByCourseName(nameCourse));
        enrollmentRepository.delete(e);}
}
