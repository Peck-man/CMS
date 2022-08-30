package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.models.Person;
import com.example.coursemanagementsystem.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminService {

    PersonRepository personRepository;

    public Person adminValidation(String username, String password){
        Person admin = personRepository.findByUserName(username);
        if (admin == null || !Objects.equals(admin.getDtype(), "administrator") || !Objects.equals(admin.getPassword(), password)) {
            return admin;
        }
        return null;
    }
}
