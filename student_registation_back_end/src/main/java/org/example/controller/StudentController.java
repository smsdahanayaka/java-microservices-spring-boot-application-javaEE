package org.example.controller;


import org.example.dao.StudentEntity;
import org.example.dto.Student;
import org.example.service.StudentService;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //Post Mapping to Get Student Object And Store Student Object
    @PostMapping("/set-student")
    public void setStudent(@RequestBody Student student){
        studentService.setStudent(student);
    }

    //Get Mapping to Pass StudentEntity Array list
    @GetMapping("/get-studentList")
    public ArrayList<StudentEntity> getStudentList(){
        return studentService.getStudent();

    }
}
