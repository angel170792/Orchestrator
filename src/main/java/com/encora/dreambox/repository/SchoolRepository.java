package com.encora.dreambox.repository;

import com.encora.dreambox.core.School;

public interface SchoolRepository {
	School findSchoolById(String id);
}
