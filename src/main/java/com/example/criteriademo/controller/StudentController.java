package com.example.criteriademo.controller;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import com.example.criteriademo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("student")
    public String getStudent(ModelMap courseModel) {
        List<Student> list = studentService.findAllStudent();
        courseModel.addAttribute("students", list);
        return "student";
    }

    @GetMapping("students")
    public String getStudentsCourses(ModelMap courseModel) {
        List<Student> list = studentService.findAllStudent();
        for (Student s : list) {
            Set<Course> courses = s.getCourses();
            for (Course c : courses) {
                System.out.println(c.getCourseName());
            }
        }
        courseModel.addAttribute("students", list);
        return "students_with_course";
    }
}
