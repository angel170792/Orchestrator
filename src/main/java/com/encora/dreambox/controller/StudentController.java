package com.encora.dreambox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.encora.dreambox.core.Student;
import com.encora.dreambox.exception.ResourceNotFoundException;
import com.encora.dreambox.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/api/student/{id}")
	public Student findStudentById(@PathVariable("id") String id) {
		Student student = studentService.findStudentById(id);
		if (student == null) {
			throw new ResourceNotFoundException("Student not found whith id: " + id);
		}
		return student;
	}
}
