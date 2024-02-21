package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Student;        
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class studentcontroller {

	@Autowired
	private StudentService studentservice;    

	public studentcontroller(StudentService studentservice) {
		super();
		this.studentservice = studentservice;   
	}
	

	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentservice.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "createstudent";
	}
	
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student Student) {
		studentservice.saveStudent(Student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentservice.getStudentById(id));
		return "editstudent";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentservice.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setBranch(student.getBranch());
		existingStudent.setUsn(student.getUsn());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentservice.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
		@GetMapping("/students/{id}")
		public String deleteStudent(@PathVariable Long id) {
			studentservice.deleteStudentById(id);
			return "redirect:/students";
		}
		
		@GetMapping("/create")
		public String createstudent() {
			return "createstudent";
		}
	
	
}
