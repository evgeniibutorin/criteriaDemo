package com.example.criteriademo.service;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
    List<Course> getCoursesByStudentName(String name);
}
