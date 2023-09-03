package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Student {

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
