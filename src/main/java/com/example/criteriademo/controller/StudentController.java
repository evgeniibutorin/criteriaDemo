package com.example.criteriademo.controller;

import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.model.Course;
import com.example.criteriademo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("student")
    public List<StudentDto> getStudent() {
        List<StudentDto> list = studentService.findAllStudent();
        return list;
    }

    @GetMapping("student/find")
    public String getStudentsByCourse(@RequestParam(value = "name") String name, ModelMap studentModel) {
        List<StudentDto> list = studentService.getStudentByCourseName(name);
        studentModel.addAttribute("students", list);
        return "student";
    }

    @GetMapping("students")
    public String getStudentsCourses(ModelMap courseModel) {
        List<StudentDto> list = studentService.findAllStudent();
        for (StudentDto s : list) {
            Set<Course> courses = s.getCourses();
            for (Course c : courses) {
                System.out.println(c.getCourseName());
            }
        }
        courseModel.addAttribute("students", list);
        return "students_with_course";
    }

    @GetMapping("student/cost")
    public String getStudentByCoursesCost(@RequestParam(value = "cost") String cost, ModelMap courseModel) {
        List<StudentDto> list = studentService.findStudentByCoursesCost(Integer.parseInt(cost));
        courseModel.addAttribute("students", list);
        return "student";
    }

    @GetMapping("/student/cost/more")
    public String getStudentWithExpensiveCourse(@RequestParam(value = "cost") String cost, ModelMap courseModel) {
        List<StudentDto> list = studentService.getStudentsWithExpensiveCourse(cost);
        courseModel.addAttribute("students", list);
        return "student";
    }

    @GetMapping("students/from/list")
    public String getStudentInList(ModelMap courseModel) {
        List<StudentDto> list = studentService.getStudentInList();
        courseModel.addAttribute("students", list);
        return "student";
    }

}
