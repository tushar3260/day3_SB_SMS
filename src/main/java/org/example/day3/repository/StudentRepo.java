package org.example.day3.repository;

import org.example.day3.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<StudentModel,String> {

}
