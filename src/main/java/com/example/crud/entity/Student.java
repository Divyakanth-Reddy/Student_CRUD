package com.example.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id  // whichever field is below this Annotation is considered as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // and this fields value will be incremented by " 1 "  automatically using this
    private long id ;
    private String studentName ; // these all will be created as columns in the STUDENT TABLE
    private String studentEmail ;
    private String studentAddress ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Student(long id, String studentName, String studentEmail, String studentAddress) {
        this.id = id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }

    public Student() {
        super();  // when we try to access the student ID which is not present this NO_ARG Constructor will be useful
    }

    @Override
    public String toString() {   //  without this method only the hexadecimal values will be displayed
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                '}';
    }
}
