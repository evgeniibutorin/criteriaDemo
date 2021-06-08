package com.example.criteriademo.dao;

import com.example.criteriademo.model.University;

import java.util.List;

public interface UniversityDao {
    List<University> listUniversity();
    University saveOne(University university);
    University getOne(int id);
}
