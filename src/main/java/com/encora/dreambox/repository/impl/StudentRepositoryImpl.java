package com.encora.dreambox.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encora.dreambox.client.DataServicesClient;
import com.encora.dreambox.core.Student;
import com.encora.dreambox.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private DataServicesClient dataServicesClient;

	@Override
	public Student findStudentById(String id) {
		return dataServicesClient.findStudentById(id);
	}
}
