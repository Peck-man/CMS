package com.example.coursemanagementsystem.models;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Teacher extends Person{

    @OneToMany
    private List<Course> courses;

    public Teacher(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
    }

    public Teacher() {

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

    public List<Course> getCourse() {
        return courses;
    }

    public void setCourse(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String getUserName() {
        return super.getUserName();
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
