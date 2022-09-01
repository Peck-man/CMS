package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.models.Person;
import com.example.coursemanagementsystem.models.Student;
import com.example.coursemanagementsystem.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentService {
    @Autowired
    PersonRepository personRepository;
    public Student validateStudent(Student student, String username, String password){
        if (areAttributesValid(student) && username.equals(student.getUserName()) && password.equals(student.getPassword())){
            return student;
        }
        return null;
    }

    public boolean areAttributesValid(Person person){
        return !person.getPassword().isEmpty() || !person.getFirstName().isEmpty() || !person.getLastName().isEmpty() || !person.getUserName().isEmpty();
    }

    public ResponseEntity validateLoginStudent(String username, String password){
        if (username.isEmpty() || password.isEmpty()){
            throw new IllegalArgumentException();
        }
        Person student = personRepository.findByUserName(username);
        if (Objects.isNull(student)){
            throw new NullPointerException();
        }
        if (!Objects.equals(student.getDtype(), "Student")){
            return new ResponseEntity<>("You are not student", HttpStatus.FORBIDDEN);

        }

        if (!Objects.equals(student.getPassword(), password)){
            return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok().body(student.getId());
    }

    public Person findById(int id){
        return personRepository.findById(id);
    }
}
