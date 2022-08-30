package com.example.coursemanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Student extends Person{

    @ManyToMany
    private List<Course> courses;

    public Student(String firstName, String lastName, String userName, String password, List<Course> courses) {
        super(firstName, lastName, userName, password);
        this.courses = courses;
    }

    public Student(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);

    }

    public Student() {

    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }
}
