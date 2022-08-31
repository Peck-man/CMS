package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.models.Person;
import com.example.coursemanagementsystem.models.Student;
import com.example.coursemanagementsystem.models.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    public Teacher validateTeacher(Teacher teacher, String username, String password){
        System.out.println(areAttributesValid(teacher));
        if (areAttributesValid(teacher) && username.equals(teacher.getUserName()) && password.equals(teacher.getPassword())){
            System.out.println(teacher);
            return teacher;
        }
        return null;
    }

    public boolean areAttributesValid(Teacher teacher){
        return !teacher.getPassword().isEmpty() || !teacher.getFirstName().isEmpty() || !teacher.getLastName().isEmpty() || !teacher.getUserName().isEmpty();
    }
}
