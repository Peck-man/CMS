package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.models.Person;
import com.example.coursemanagementsystem.models.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student validateStudent(Student student, String username, String password){
        System.out.println(areAttributesValid(student));
        if (areAttributesValid(student) && username.equals(student.getUserName()) && password.equals(student.getPassword())){
            System.out.println(student);
            return student;
        }
        return null;
    }

    public boolean areAttributesValid(Person person){
        return !person.getPassword().isEmpty() || !person.getFirstName().isEmpty() || !person.getLastName().isEmpty() || !person.getUserName().isEmpty();
    }
}
