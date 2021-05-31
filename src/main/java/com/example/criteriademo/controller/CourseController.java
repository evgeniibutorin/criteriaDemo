package com.example.criteriademo.controller;

import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import com.example.criteriademo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("course")
    public String getCourses(ModelMap courseModel) {
        List<CourseDto> list = courseService.findAllCourses();
        courseModel.addAttribute("courses", list);
        return "course";
    }

    @GetMapping("courses")
    public String getCoursesWithStudentName(ModelMap courseModel) {
        List<CourseDto> list = courseService.findAllCourses();
        for (CourseDto course : list) {
            Set<Student> students = course.getStudents();
            for (Student s : students) {
                System.out.println(s.getStudentName());
            }
        }
        courseModel.addAttribute("courses", list);
        return "students_courses";
    }

    @GetMapping("/courses/find")
    public String getCoursesByStudentName(@RequestParam(value = "name") String name, ModelMap courseModel) {
        List<CourseDto> list = courseService.getCoursesByStudentName(name);
        courseModel.addAttribute("courses", list);
        return "course";
    }
    @GetMapping("/expensive_courses")
    public String getExpensiveCourse( ModelMap courseModel) {
        List<CourseDto> list = courseService.findExpensiveCourse();
        courseModel.addAttribute("courses", list);
        return "course";
    }




}
