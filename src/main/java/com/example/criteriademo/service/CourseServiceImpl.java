package com.example.criteriademo.service;

import com.example.criteriademo.dao.CourseDao;
import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.model.Course;
import org.dozer.DozerBeanMapper;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;
    private final DozerBeanMapper mapingUtis;

    public CourseServiceImpl(CourseDao courseDao, DozerBeanMapper mapingUtis) {
        this.courseDao = courseDao;
        this.mapingUtis = mapingUtis;
    }

    @Override
    @Transactional
    public List<CourseDto> findAllCourses() {
//        List<Course> list = courseDao.listCourses();
//        return list;
        return courseDao.listCourses().stream()
                .map(student -> mapingUtis.map(student, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CourseDto> getCoursesByStudentName(String name) {
        List<CourseDto> courses = courseDao.findCoursesByStudentName(name).stream()
                .map(course -> mapingUtis.map(course, CourseDto.class))
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
                .map(course -> mapingUtis.map(course, CourseDto.class))
                .collect(Collectors.toList());
        return list;
    }

}
