package com.example.demo.rest;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeFilesRepository extends MongoRepository<EmployeeFiles, Long> {

	EmployeeFiles findByEid(String eid);
}
