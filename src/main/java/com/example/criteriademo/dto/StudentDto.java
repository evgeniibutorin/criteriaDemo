package com.example.criteriademo.dto;

import com.example.criteriademo.model.Course;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class StudentDto {

    int id;
    String studentName;
    Set<Course> courses = new HashSet<>();
}
