package com.example.criteriademo.service;

import com.example.criteriademo.dao.CourseDao;
import com.example.criteriademo.model.Course;
import org.hibernate.Hibernate;
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

    @Override
    @Transactional
    public List<Course> getCoursesByStudentName(String name) {
        List<Course> courses = courseDao.findCoursesByStudentName(name);
        for (Course course : courses) {
            Hibernate.initialize(course.getStudents());
        }
        return courses;
    }

    @Override
    @Transactional
    public List<Course> findExpensiveCourse() {
        List<Course> list = courseDao.findExpensiveCourse();
        return list;
    }

}
