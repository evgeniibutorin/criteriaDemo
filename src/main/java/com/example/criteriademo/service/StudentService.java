package com.example.criteriademo.service;

import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAllStudent();
    List<StudentDto> getStudentByCourseName(String name);
    List<StudentDto> findStudentByCoursesCost(int cost);
    List<StudentDto> getStudentsWithExpensiveCourse(String cost);
    List<StudentDto> getStudentInList();
}
