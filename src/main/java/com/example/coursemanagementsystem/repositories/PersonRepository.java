package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Person;
import com.example.coursemanagementsystem.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findById(int id);
    Person findByUserName(String username);
    List<Person> findAllByDtype(String name);


}
