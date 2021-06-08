package com.example.criteriademo.service;

import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.dto.UniversityDto;
import com.example.criteriademo.model.University;

import java.util.List;

public interface UniversityService {
    List<UniversityDto> findAllUniversity();
    University save(University university);
}
