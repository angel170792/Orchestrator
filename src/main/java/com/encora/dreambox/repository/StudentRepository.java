package com.encora.dreambox.repository;

import com.encora.dreambox.core.Student;

public interface StudentRepository {
	Student findStudentById(String id);
}
