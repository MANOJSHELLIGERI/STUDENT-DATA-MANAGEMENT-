package com.example.service;

import java.util.List; 

import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repositories.StudentRepository;

@Service
public class studentserviceimp implements StudentService{

private StudentRepository studentRepository;
	
	public studentserviceimp(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}
 
}
