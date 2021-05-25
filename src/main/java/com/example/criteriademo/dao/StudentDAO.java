package com.example.criteriademo.dao;

import com.example.criteriademo.model.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> listStudents();
    List<Student> findStudentsByCoursesName(String courseName);
    List<Student> findStudentByCoursesCost(int cost);
    List<Student> findStudentWithExpensiveCourse(String cost);
    List<Student> findStudentInSomeList();
}
