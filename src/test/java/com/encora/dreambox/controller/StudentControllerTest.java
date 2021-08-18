package com.encora.dreambox.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.encora.dreambox.core.Student;
import com.encora.dreambox.service.StudentService;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Test
	void studentExists() throws Exception {
		Student student = new Student("1", "Angel", "Solorzano", "29", "3rd", null);
		when(studentService.findStudentById("1")).thenReturn(student);
		this.mockMvc.perform(get("/api/student/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void studentDoesNotExist() throws Exception {
		when(studentService.findStudentById("22")).thenReturn(null);
		this.mockMvc.perform(get("/api/school/22")).andDo(print()).andExpect(status().isNotFound());
	}

}
