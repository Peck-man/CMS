package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
