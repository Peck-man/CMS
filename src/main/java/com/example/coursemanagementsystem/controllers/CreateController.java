package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.*;
import com.example.coursemanagementsystem.repositories.CourseRepository;
import com.example.coursemanagementsystem.repositories.PersonRepository;
import com.example.coursemanagementsystem.services.CourseService;
import com.example.coursemanagementsystem.services.StudentService;
import com.example.coursemanagementsystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/administrator")
public class CreateController {

    StudentService studentService;
    TeacherService teacherService;
    PersonRepository personRepository;
    CourseRepository courseRepository;
    CourseService courseService;

    public CreateController(StudentService studentService, TeacherService teacherService, PersonRepository personRepository, CourseRepository courseRepository, CourseService courseService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.personRepository = personRepository;
        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

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
    @GetMapping("/create-course")
    public String fillCourseForm(Model model){
        model.addAttribute("teachers", personRepository.findAllByDtype("Teacher"));
        model.addAttribute("students", personRepository.findAllByDtype("Student"));
        return "courseForm";
    }

    @PostMapping("/create-course")
    public String createCourse(CourseDTO courseDTO){
        Course course;
        try {
            course = courseService.createCourse(courseDTO.getCourseName(), courseDTO.getTeacherUserName(), courseDTO.getStudents());
        } catch (IllegalArgumentException e){
            return "redirect:/administrator/create-course";
        }
        System.out.println(course);
        courseRepository.save(course);
        return "redirect:/administrator/login";

    }

    }
