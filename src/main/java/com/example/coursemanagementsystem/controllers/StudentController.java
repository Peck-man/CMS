package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/login")
    public String getForm() {
        return "studentLogin";
    }

    @PostMapping("/login")
    public String validationStudent(String username,
                                    String password, Model model) {
        ResponseEntity number;
        try {
            number = studentService.validateLoginStudent(username, password);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Something is empty");
            return "studentLogin";
        } catch (NullPointerException e) {
            model.addAttribute("error", "We didnt find him");
            return "studentLogin";
        }

        if (number.getStatusCodeValue() == 401) {
            model.addAttribute("error", number.getBody());
            return "studentLogin";
        } else if (number.getStatusCodeValue() == 403) {
            model.addAttribute("error",number.getBody());
            return "studentLogin";
        } else {
            return "redirect:/student/" + number.getBody();
        }
    }

        @GetMapping("/student/{id}")
        public void showMainMenu (@PathVariable String id){

        }
    }

