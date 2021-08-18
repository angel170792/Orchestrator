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

import com.encora.dreambox.core.School;
import com.encora.dreambox.repository.SchoolRepository;

@ExtendWith(MockitoExtension.class)
class SchoolServiceImplTest {

	@Mock
	private SchoolRepository schoolRepository;

	@Autowired
	@InjectMocks
	private SchoolServiceImpl schoolService;

	@Mock
	private School school;

	private String id = "1";

	@Test
	void schoolExists() {
		when(schoolRepository.findSchoolById(id)).thenReturn(school);
		School school = schoolService.findSchoolById(id);
		assertNotNull(school);
	}

	@Test
	void schoolDoesNotExist() {
		when(schoolRepository.findSchoolById(id)).thenReturn(null);
		School school = schoolService.findSchoolById(id);
		assertNull(school);
	}

}
