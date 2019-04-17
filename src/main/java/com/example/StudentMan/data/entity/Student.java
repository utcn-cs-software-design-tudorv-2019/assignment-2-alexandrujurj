package com.example.StudentMan.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "students")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId = 0;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "pnc")
	private int pnc = 0;

	@Column(name = "card_number")
	private int cardNumber = 0;

	@Column(name = "group")
	private int group = 0;
	// optional
	@Column(name = "email")
	private String email = "";

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "enrollments", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private List<Course> courses;

	public Student() {
	}

	public Student(int studentId, String studentName, int pnc, int cardNumber, int group, String email) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.cardNumber = cardNumber;
		this.pnc = pnc;
		this.group = group;
		this.email = email;
		this.courses = new ArrayList<Course>();
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getPnc() {
		return pnc;
	}

	public void setPnc(int pnc) {
		this.pnc = pnc;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                pnc == student.pnc &&
                cardNumber == student.cardNumber &&
                group == student.group &&
                Objects.equals(studentName, student.studentName) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, studentName, pnc, cardNumber, group, email);
    }

    @Override
    public String toString() {
        return "Student " +
                "studentId=" + studentId +
                ", studentName='" + studentName +
                ", pnc=" + pnc +
                ", cardNumber=" + cardNumber +
                ", group=" + group +
                ", email=" + email ;

}

}