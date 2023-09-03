package org.example.service;

import org.example.dao.StudentEntity;
import org.example.dto.Student;

import java.util.ArrayList;

public interface StudentService {
    public void setStudent(Student student); //Method to set student


    ArrayList<StudentEntity> getStudent(); //method to return students list
}
