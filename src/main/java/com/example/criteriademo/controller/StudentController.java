package com.example.criteriademo.controller;

import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("student")
    public List<StudentDto> getStudent() {
        List<StudentDto> students = studentService.findAllStudent();
        return students;
    }

    @GetMapping("student/find")
    public List<StudentDto> getStudentsByCourse(@RequestParam(value = "name") String name) {
        List<StudentDto> students = studentService.getStudentByCourseName(name);
        return students;
    }


    @GetMapping("student/cost")
    public List<StudentDto> getStudentByCoursesCost(@RequestParam(value = "cost") String cost) {
        List<StudentDto> students = studentService.findStudentByCoursesCost(Integer.parseInt(cost));
        return students;
    }

    @GetMapping("/student/cost/more")
    public List<StudentDto> getStudentWithExpensiveCourse(@RequestParam(value = "cost") String cost) {
        List<StudentDto> students = studentService.getStudentsWithExpensiveCourse(cost);
        return students;
    }

    @GetMapping("/students/from/list")
    public List<StudentDto> getStudentInList() {
        List<StudentDto> students = studentService.getStudentInList();
        return students;
    }

}
