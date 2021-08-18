package com.encora.dreambox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.encora.dreambox.core.School;
import com.encora.dreambox.exception.ResourceNotFoundException;
import com.encora.dreambox.service.SchoolService;

@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@GetMapping("/api/school/{id}")
	public School findSchoolById(@PathVariable("id") String id) throws Exception {
		School school = schoolService.findSchoolById(id);
		if (school == null) {
			throw new ResourceNotFoundException("School not found whith id: " + id);
		}
		return school;
	}
}
