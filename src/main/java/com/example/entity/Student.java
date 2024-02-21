package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	             
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "usn")
	private String usn;
	
	@Column(name = "email")
	private String email;

	public Student() {
		}

	public Student(Long id, String firstName, String lastName, String branch, String usn, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
		this.usn = usn;
		this.email = email;
	}
       
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", branch=" + branch
				+ ", usn=" + usn + ", email=" + email + "]";
	}
	
	
	
}
