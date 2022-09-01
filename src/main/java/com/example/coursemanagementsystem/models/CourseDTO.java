package com.example.coursemanagementsystem.models;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CourseDTO {
    @NotEmpty(message = "Course's name cannot be empty.")
    private String courseName;
    private String  teacherUserName;
    private List<String> students;

    public CourseDTO(String courseName, String teacherUserName, List<String> students) {
        this.courseName = courseName;
        this.teacherUserName = teacherUserName;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherUserName() {
        return teacherUserName;
    }

    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }
}
