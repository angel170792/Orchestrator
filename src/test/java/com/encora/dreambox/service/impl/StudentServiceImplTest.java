package com.encora.dreambox.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.encora.dreambox.core.Student;
import com.encora.dreambox.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

	@Mock
	private StudentRepository studentRepository;

	@Mock
	private Student student;

	@Autowired
	@InjectMocks
	private StudentServiceImpl studentService;

	private String id = "1";

	@Test
	void studentExists() {
		when(studentRepository.findStudentById(id)).thenReturn(student);
		Student student = studentService.findStudentById(id);
		assertNotNull(student);
	}

	@Test
	void studentDoesNotExist() {
		when(studentRepository.findStudentById(id)).thenReturn(null);
		Student student = studentService.findStudentById(id);
		assertNull(student);
	}

}
