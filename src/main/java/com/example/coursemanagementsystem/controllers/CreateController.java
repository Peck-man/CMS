package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.Student;
import com.example.coursemanagementsystem.models.Teacher;
import com.example.coursemanagementsystem.repositories.PersonRepository;
import com.example.coursemanagementsystem.services.StudentService;
import com.example.coursemanagementsystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/administrator")
public class CreateController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    PersonRepository personRepository;


    @GetMapping("/create-student")
    public String fillStudentForm(){
        return "studentForm";
    }

    @PostMapping("/create-student")
    public String createStudent(Student student,
                                @RequestParam String usernameConfirm,
                                @RequestParam String passwordConfirm){
    try {
        personRepository.save(studentService.validateStudent(student,usernameConfirm,passwordConfirm));
        return "redirect:/administrator/login";
    } catch (Exception e){
        return "studentFormUnsuccessful";
    }

        }
    @GetMapping("/create-instructor")
    public String fillTeacherForm(){
        return "teacherForm";
    }

    @PostMapping("/create-instructor")
    public String createTeacher(Teacher teacher,
                                @RequestParam String usernameConfirm,
                                @RequestParam String passwordConfirm){
        try {
            personRepository.save(teacherService.validateTeacher(teacher,usernameConfirm,passwordConfirm));
            return "redirect:/administrator/login";
        } catch (Exception e){
            return "teacherFormUnsuccessful";
        }

    }

    }
