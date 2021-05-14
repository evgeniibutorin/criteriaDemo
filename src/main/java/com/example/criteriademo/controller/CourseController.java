package com.example.criteriademo.controller;

import com.example.criteriademo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    ///WEB-INF/view
    @GetMapping("course")
    public String getCourses() {
//        List<Course> list = courseService.findAllCourses();
//        for (Course c:list){
//            System.out.println(c.getCourseName());
//        }
        System.out.println("I am working");
        return "hello";
    }
}
