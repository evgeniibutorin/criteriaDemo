package com.example.criteriademo.controller;

import com.example.criteriademo.dto.UniversityDto;
import com.example.criteriademo.service.UniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("university")
    public List<UniversityDto> getStudent() {
        List<UniversityDto> list = universityService.findAllUniversity();
        return list;
    }
}
