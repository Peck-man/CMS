package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.models.Person;
import com.example.coursemanagementsystem.models.PersonDTO;
import com.example.coursemanagementsystem.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/administrator")
public class AdminController {

    @Autowired
    private AdminService adminService;



    @GetMapping("/login")
    public String login() {
        return "adminLogin";
    }

    @PostMapping("/login")
    public String loggedIn(PersonDTO personDTO, Model model){
        try {
            Person person = adminService.adminValidation(personDTO.getUsername(), personDTO.getPassword());
            model.addAttribute("firstName", person.getFirstName());
            model.addAttribute("lastName", person.getLastName());
                return "adminLoggedIn";
        } catch (NullPointerException e){
            return "adminLoginUnsuccessful";
        }

    }

}
