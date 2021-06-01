package com.example.criteriademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    @GetMapping("/course_home_page")
    public String getCourseStartedPage() {
        return "course_home_page";
    }

    @GetMapping("/university_home_page")
    public String getUniversityStartedPage() {
        return "university";
    }

}
