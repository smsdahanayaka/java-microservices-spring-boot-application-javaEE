package org.example.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class StudentEntity {

//    Student
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Student details
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDay;
    private int age;

    // Add Property variable
    @Value("${student.school}")
    private String school;

    // Add guardian details
    private String guardianName;
    private String address;
    private String contactNumber;
}
