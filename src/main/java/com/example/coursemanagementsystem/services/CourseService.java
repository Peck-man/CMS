package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.models.Course;
import com.example.coursemanagementsystem.models.Person;
import com.example.coursemanagementsystem.models.Student;
import com.example.coursemanagementsystem.models.Teacher;
import com.example.coursemanagementsystem.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseService {

    PersonRepository personRepository;

    public CourseService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Course createCourse(String courseName,
                               String teacherName,
                               List<String> students){

        if (courseName.isEmpty()){
            throw new IllegalArgumentException();
        }
        Teacher teacher = (Teacher) personRepository.findByUserName(teacherName);
        List<Student> studentList = new ArrayList<>();
        if (students != null) {
            students.forEach(s -> {studentList.add((Student) personRepository.findByUserName(s));});
        }

        return new Course(courseName,studentList, teacher);
    }
}
