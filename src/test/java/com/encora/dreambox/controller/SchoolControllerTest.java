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

import com.encora.dreambox.core.School;
import com.encora.dreambox.service.SchoolService;

@WebMvcTest(SchoolController.class)
class SchoolControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SchoolService schoolService;

	@Test
	void schoolExists() throws Exception {
		School school = new School("1", "ESCOM");
		when(schoolService.findSchoolById("1")).thenReturn(school);
		this.mockMvc.perform(get("/api/school/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void schoolDoesNotExist() throws Exception {
		when(schoolService.findSchoolById("22")).thenReturn(null);
		this.mockMvc.perform(get("/api/school/22")).andDo(print()).andExpect(status().isNotFound());
	}

}
