package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import edu.icet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService implements StudentServiceInt{

    @Autowired
    StudentRepository studentRepository;
    @Value("${student.institute}")
    String institue;
    public ArrayList<Student> getStudent(){
        ArrayList<Student> studentArrayList=new ArrayList<>();
        studentArrayList.add(new Student("shan","dahanayaka","malabe",institue));
        studentArrayList.add(new Student("kamal","piyal","akurasse",institue));
        studentArrayList.add(new Student("ajanatha","renu","mathara",institue));
        return studentArrayList;
    }

    public void addStudent(Student student){

        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setAddress(student.getAddress());

        studentRepository.save(studentEntity);

    }
}
