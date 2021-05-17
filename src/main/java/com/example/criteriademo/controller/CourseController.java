package com.example.criteriademo.controller;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    ///WEB-INF/view
    @GetMapping("course")
    public String getCourses(ModelMap courseModel) {
        List<Course> list = courseService.findAllCourses();
        courseModel.addAttribute("courses", list);
        return "course";
    }
}
