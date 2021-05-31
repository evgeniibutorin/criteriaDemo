package com.example.criteriademo.service;

import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAllCourses();
    List<CourseDto> getCoursesByStudentName(String name);
    List<CourseDto> findExpensiveCourse();
}
