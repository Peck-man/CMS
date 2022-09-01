package com.example.coursemanagementsystem.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String courseName;
    @ManyToMany
    List<Student> student;
    @ManyToOne
    Teacher teacher;

    public Course(String courseName, List<Student> student, Teacher teacher) {
        this.courseName = courseName;
        this.student = student;
        this.teacher = teacher;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
