package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String loggedIn(@RequestBody String username, String password){
        try {
            adminService.adminValidation(username,password);
                return "adminLoggedIn";
        } catch (NullPointerException e){
            return "adminLoginUnsuccessful";
        }

    }
}
