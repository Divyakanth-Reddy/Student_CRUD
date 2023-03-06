package com.example.crud.controller;

import com.example.crud.entity.Student;
import com.example.crud.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo ;
    @PostMapping("/api/students")
    // this requestbody annotation helps to avoid when the data is empty and will make the field as mandatory
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
         return new ResponseEntity<> (studentRepo.save(student), HttpStatus.CREATED );

    }

    @GetMapping("/api/students")
    public ResponseEntity <List<Student>> getStudents(){ // this method is going to return list of users
            return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK) ;
    }

    @GetMapping("/api/students/{id}")
    public ResponseEntity <Student> getStudent(@PathVariable long id){ // this is how we get the id using path param which is path variable
        Optional<Student> student = studentRepo.findById(id) ;
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @PutMapping("/api/students/{id}")
    public ResponseEntity <Student> updateStudent(@PathVariable long id , @RequestBody Student stud){ // this is how we get the id using path param which is path variable
        Optional<Student> student = studentRepo.findById(id) ;
        if (student.isPresent()) {
            student.get().setStudentName(stud.getStudentName());
            student.get().setStudentEmail(stud.getStudentEmail());
            student.get().setStudentAddress(stud.getStudentAddress());
            return new ResponseEntity<>(studentRepo.save(student.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity <Void> deleteStudent(@PathVariable long id ){ // this is how we get the id using path param which is path variable
        Optional<Student> student = studentRepo.findById(id) ;
        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }



}

