package com.example.StudentMan.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentMan.data.entity.Course;
import com.example.StudentMan.data.entity.Student;
import com.example.StudentMan.data.repository.CourseDao;
//import com.example.StudentMan.data.repository.EnrollmentDao;
import com.example.StudentMan.data.repository.StudentDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentRepository;

    @Autowired
    private CourseDao courseRepository;

   // @Autowired
   // private EnrollmentDao enrollmentRepository;

    public Student viewPersonalInformation(String nameStudent)
    { return studentRepository.getByStudentName(nameStudent); }


    ;public void updateEmail(String nameStudent,String email)
    {
        Student s=studentRepository.getByStudentName(nameStudent);
        s.setEmail(email);
        studentRepository.save(s);
    }

    public void deletePersonalInformation(String nameStudent)
    { studentRepository.delete(studentRepository.getByStudentName(nameStudent)); }

    public List<Course> viewCourses(Student student)
    {
        List<Course> studentCourses=studentRepository.getCourses(student.getStudentName());
        List<Course> allCourses= (ArrayList<Course>) courseRepository.findAll();
        allCourses.removeAll(studentCourses);
        return allCourses;
    }

    public Student getStudent(String username)
    {
        return studentRepository.getByStudentName(username);
    }
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }
}