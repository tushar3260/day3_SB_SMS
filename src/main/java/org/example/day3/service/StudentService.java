package org.example.day3.service;

import org.example.day3.model.StudentModel;
import org.example.day3.repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    private final StudentRepo repository;

    public StudentService(StudentRepo repository) {
        this.repository = repository;
    }

    //create
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

}
