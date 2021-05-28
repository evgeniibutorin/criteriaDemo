package com.example.criteriademo.service;

import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAllCourses();
    List<Course> getCoursesByStudentName(String name);
    List<Course> findExpensiveCourse();
}
