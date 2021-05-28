package com.example.criteriademo.dto;

import com.example.criteriademo.model.Student;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CourseDto {

    int id;
    String courseName;
    int courseCost;
    Set<Student> students = new HashSet<>();
}

