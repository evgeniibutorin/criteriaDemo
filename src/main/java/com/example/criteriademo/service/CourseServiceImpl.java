package com.example.criteriademo.service;

import com.example.criteriademo.dao.CourseDao;
import com.example.criteriademo.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    @Transactional
    public List<Course> findAllCourses() {
        List<Course> list = courseDao.listCourses();
        return list;
    }
}
