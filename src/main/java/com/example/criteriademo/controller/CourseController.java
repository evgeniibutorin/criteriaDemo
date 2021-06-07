package com.example.criteriademo.controller;

import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.model.Course;
import com.example.criteriademo.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("course")
    public List<CourseDto> getCourses() {
        List<CourseDto> courses = courseService.findAllCourses();
        return courses;
    }

    @GetMapping("/courses/find")
    public List<CourseDto> getCoursesByStudentName(@RequestParam(value = "name") String name) {
        List<CourseDto> courses = courseService.getCoursesByStudentName(name);
        return courses;
    }

    @GetMapping("/expensive_courses")
    public List<CourseDto> getExpensiveCourse() {
        List<CourseDto> courses = courseService.findExpensiveCourse();
        return courses;
    }


}
