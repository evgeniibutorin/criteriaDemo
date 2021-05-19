package com.example.criteriademo.service;

import com.example.criteriademo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    List<Student> getStudentByCourseName(String name);
}
