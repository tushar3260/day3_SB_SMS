package org.example.day3.service;

import org.example.day3.dto.StudentRequestDto;
import org.example.day3.dto.StudentResponseDto;
import org.example.day3.exception.StudentNotFoundException;
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

    public StudentResponseDto addStudent(StudentRequestDto dto) {
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }




//    public StudentModel addStudent(StudentModel student){
//        return
//                repository.save(student);
//    }

    // get student
//    public List<StudentModel> getStudent(){
//        return repository.findAll();
//
//    }

    public List<StudentResponseDto> getAllStudent(){
        return repository.findAll()
                .stream()
                .map(s-> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }


    //  READ BY ID
    public StudentResponseDto getStudentById(String id) {
        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }


    // update Student

    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {
        StudentModel existing = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setEmail(dto.getEmail());

        StudentModel updated = repository.save(existing);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }



    //delete by id

    public void deleteById(String id){
        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        repository.delete(student);
    }

}
