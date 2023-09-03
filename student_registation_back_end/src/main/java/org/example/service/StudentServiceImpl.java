package org.example.service;

import org.example.dao.StudentEntity;
import org.example.dto.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    @Value("${student.school}")
    private String school;

    // Implement setStudent method
    public void setStudent(Student student) {

        StudentEntity studentEntity=new StudentEntity();// Create StudentEntity class object


        // set values for studentEntity object
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setMiddleName(student.getMiddleName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setAge(student.getAge());
        studentEntity.setBirthDay(student.getBirthDay());
        studentEntity.setGuardianName(student.getGuardianName());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setContactNumber(student.getContactNumber());
        studentEntity.setSchool(school);

        studentRepository.save(studentEntity); //StudentEntity object pass to crud repository

    }

    // implements getStudent method
    public ArrayList<StudentEntity> getStudent(){
        return (ArrayList<StudentEntity>) studentRepository.findAll();//get all student details list and return
    }
}
