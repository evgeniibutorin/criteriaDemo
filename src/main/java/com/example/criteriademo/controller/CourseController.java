package com.example.criteriademo.controller;

import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
        CourseDto courseDto = new CourseDto();
        return courseDto.getCourseDtoList(courseService.findAllCourses());
    }

    @GetMapping("/courses/find")
    public List<CourseDto> getCoursesByStudentName(@RequestParam(value = "name") String name) {
        CourseDto courseDto = new CourseDto();
        return courseDto.getCourseDtoList(courseService.getCoursesByStudentName(name));
    }

//    GetMapping("/courses/find")
//    public String getCoursesByStudentName(@RequestParam(value = "name") String name, ModelMap courseModel) {
//        List<CourseDto> list = courseService.getCoursesByStudentName(name);
//        courseModel.addAttribute("courses", list);
//        return "course";
//    }


    @GetMapping("/expensive_courses")
    public List<CourseDto> getExpensiveCourse() {
        CourseDto courseDto = new CourseDto();
        return courseDto.getCourseDtoList(courseService.findExpensiveCourse());
    }

//    @GetMapping("/expensive_courses")
//    public String getExpensiveCourse(ModelMap courseModel) {
//        List<CourseDto> list = courseService.findExpensiveCourse();
//        courseModel.addAttribute("courses", list);
//        return "course";
//    }

}
