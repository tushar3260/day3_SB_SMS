package org.example.day3.controller;

import jakarta.validation.Valid;
import org.example.day3.dto.StudentRequestDto;
import org.example.day3.dto.StudentResponseDto;
import org.example.day3.model.StudentModel;
import org.example.day3.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {
   private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    // create function API

    @PostMapping("add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }

//        @PostMapping("/add-student")
//        public StudentModel addStudent(@RequestBody StudentModel student){
//
//            return service.addStudent(student);
//        }

//    @GetMapping("/student")
//    public List<StudentModel> getStudent() {
//        return service.getStudent();
//    }

    @GetMapping("/student")
    public List<StudentResponseDto> getStudent(){
        return service.getAllStudent();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(
            @PathVariable String id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable String id,
            @RequestBody StudentRequestDto student) {
        return service.updateStudent(id, student);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        service.deleteById(id);
    }

}
