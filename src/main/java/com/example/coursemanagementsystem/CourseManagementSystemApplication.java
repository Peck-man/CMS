package com.example.coursemanagementsystem;

import com.example.coursemanagementsystem.models.Student;
import com.example.coursemanagementsystem.models.Teacher;
import com.example.coursemanagementsystem.repositories.PersonRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseManagementSystemApplication implements ApplicationRunner {
    PersonRepository personRepository;

    public CourseManagementSystemApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementSystemApplication.class, args);

    }
    @Override
    public void run(ApplicationArguments args) {
        personRepository.save(new Student("Borec", "Jsem", "jsemBorec", "master"));
        personRepository.save(new Teacher("Učitel", "Jsem", "jsemUčitel", "master"));
        System.out.println(personRepository.findById(1));
        System.out.println(personRepository.findById(2));
        System.out.println(personRepository.findAllByDtype("Teacher"));
    }
}
