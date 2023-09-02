package edu.icet.service;

import edu.icet.dto.Student;
import java.util.ArrayList;

public interface StudentServiceInt {
    public ArrayList<Student> getStudent();

    void addStudent(Student student);
}
