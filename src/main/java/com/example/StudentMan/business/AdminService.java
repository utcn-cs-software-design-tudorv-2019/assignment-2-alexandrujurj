package com.example.StudentMan.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentMan.data.entity.Admin;
import com.example.StudentMan.data.entity.Course;
import com.example.StudentMan.data.repository.AdminDao;
import com.example.StudentMan.data.repository.CourseDao;
import com.example.StudentMan.data.repository.StudentDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminRepository;

    @Autowired
    private StudentDao studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private CourseDao courseRepository;


    /*public void generateReport(String nameStudent)
    {}*/

    public void deleteEnrollment(String nameStudent,String courseName,int grade)
    { enrollmentService.deleteEnrollment(nameStudent,courseName);}

    public void setGrade(String studentName,String courseName,int grade)
    { enrollmentService.setGrade(studentName,courseName,grade);}

    public List<Course> getCourses()
    {
        return courseRepository.findAll();
    }
    public Optional<Admin> getAdmin()
    {
        return adminRepository.findById(1);
    }
    public void addCourse(Course course)
    {
        courseRepository.save(course);
    }
    public int getIDCourse()
    {
       List<Course> c= new ArrayList<Course>();
       c=courseRepository.findAll();
       return c.size()+1;

    }
}