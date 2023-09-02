package edu.icet.controler;

import edu.icet.service.StudentService;
import edu.icet.dto.Student;
import edu.icet.service.StudentServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    StudentServiceInt studentService;

    @GetMapping("/get-student")
    public ArrayList<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping("set-student")
    public void setStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
}
