package com.example.criteriademo.service;

import com.example.criteriademo.dao.CourseDao;
import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import org.dozer.DozerBeanMapper;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;
    private final DozerBeanMapper beanMapper;

    public CourseServiceImpl(CourseDao courseDao, DozerBeanMapper beanMapper) {
        this.courseDao = courseDao;
        this.beanMapper = beanMapper;
    }

    @Override
    @Transactional
    public List<Course> findAllCourses() {
        List <Course> courses = courseDao.listCourses();
        for (Course course : courses) {
            Hibernate.initialize(course.getStudents());
        }
        return courses;
    }

    @Override
    @Transactional
    public List<CourseDto> getCoursesByStudentName(String name) {
        List<CourseDto> courses = courseDao.findCoursesByStudentName(name).stream()
                .map(course -> beanMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
        for (CourseDto course : courses) {
            Hibernate.initialize(course.getStudents());
        }
        return courses;
    }

    @Override
    @Transactional
    public List<CourseDto> findExpensiveCourse() {
        List<CourseDto> list = courseDao.findExpensiveCourse().stream()
                .map(course -> beanMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
        return list;
    }

}
