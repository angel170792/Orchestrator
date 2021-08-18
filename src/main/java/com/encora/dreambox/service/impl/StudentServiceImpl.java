package com.encora.dreambox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.dreambox.core.Student;
import com.encora.dreambox.repository.StudentRepository;
import com.encora.dreambox.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student findStudentById(String id) {
		return studentRepository.findStudentById(id);
	}
}
