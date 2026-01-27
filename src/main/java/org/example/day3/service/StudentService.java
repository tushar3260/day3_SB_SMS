package org.example.day3.service;

import org.example.day3.model.StudentModel;
import org.example.day3.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    private final StudentRepo repository;

    public StudentService(StudentRepo repository) {
        this.repository = repository;
    }

    //create
    public StudentModel addStudent(StudentModel student){
        return
                repository.save(student);
    }

    // get student
    public List<StudentModel> getStudent(){
        return repository.findAll();

    }


    //  READ BY ID
    public StudentModel getStudentById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // update Student

    public StudentModel updateStudent(String id, StudentModel student) {
        StudentModel existingStudent = getStudentById(id);

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());

        return repository.save(existingStudent);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

}
