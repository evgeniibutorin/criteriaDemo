package com.example.criteriademo.dto;

import com.example.criteriademo.model.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
public class CourseDto {

    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String courseName;

    @Getter
    @Setter
    int cost;

    @Getter
    @Setter
    Set<Student> students = new HashSet<>();
}

