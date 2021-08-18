package com.encora.dreambox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.dreambox.core.School;
import com.encora.dreambox.repository.SchoolRepository;
import com.encora.dreambox.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public School findSchoolById(String id) {
		return schoolRepository.findSchoolById(id);
	}

}
