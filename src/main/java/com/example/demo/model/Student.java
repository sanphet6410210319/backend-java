package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String std;
	public String getStd() {
		return std;
	}
	public Student(String std, String studentId, String name, String email) {
		super();
		this.std = std;
		this.studentId = studentId;
		this.name = name;
		this.email = email;
	}
	public Student() {
		super();
	}
	public void setStd(String std) {
		this.std = std;
	}
	private String studentId;
	private String name;
	private String email;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

	


	
	
	
	
