package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findById(int id);
}
