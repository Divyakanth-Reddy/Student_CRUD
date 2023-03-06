package com.example.crud.repo ;

import com.example.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long > {


}