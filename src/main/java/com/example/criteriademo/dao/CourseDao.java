package com.example.criteriademo.dao;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;

import java.util.List;

public interface CourseDao {
    List<Course> listCourses();
    List<Course> findCoursesByStudentName(String studentName);
    List<Course> findExpensiveCourse();
}
