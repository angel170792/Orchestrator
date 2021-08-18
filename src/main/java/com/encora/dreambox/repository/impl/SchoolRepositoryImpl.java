package com.encora.dreambox.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encora.dreambox.client.DataServicesClient;
import com.encora.dreambox.core.School;
import com.encora.dreambox.repository.SchoolRepository;

@Repository
public class SchoolRepositoryImpl implements SchoolRepository {

	@Autowired
	private DataServicesClient dataServicesClient;

	@Override
	public School findSchoolById(String id) {
		return dataServicesClient.findSchoolById(id);
	}
}
