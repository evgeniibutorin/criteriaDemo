package com.example.criteriademo.controller;

import com.example.criteriademo.dto.UniversityDto;
import com.example.criteriademo.model.University;
import com.example.criteriademo.service.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("university")
    @ResponseBody
    public List<UniversityDto> getStudent() {
        List<UniversityDto> list = universityService.findAllUniversity();
        return list;
    }

    @PostMapping("university/add")
    @ResponseBody
    public University create(@RequestBody University university) {

        return universityService
                .save(university);
    }
}
