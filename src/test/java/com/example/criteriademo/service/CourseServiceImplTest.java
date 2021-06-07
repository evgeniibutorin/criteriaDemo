package com.example.criteriademo.service;

import com.example.criteriademo.config.MappingConfig;
import com.example.criteriademo.dao.CourseDao;
import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

    @Spy
    private DozerBeanMapper dozer;

    @Test
    public void findAllCourses() {
        Student max = new Student(0, "Max", null);
        Student jon = new Student(1, "Jon", null);
        Student linda = new Student(2, "Linda", null);
        Set<Student> studentsJavarush = new HashSet<>(Arrays.asList(max, jon));
        Set<Student> studentsStepic = new HashSet<>(Arrays.asList(max, jon, linda));
        Set<Student> studentsLanit = new HashSet<>(Arrays.asList(max, linda));
        Course javarush = new Course(0, "javarush", 500, studentsJavarush);
        Course stepic = new Course(1, "stepic", 300, studentsStepic);
        Course lanit = new Course(2, "lanit", 100, studentsLanit);
        List<Course> courses = new ArrayList<>(Arrays.asList(javarush, stepic, lanit));

        CourseDto javarushDTO = new CourseDto(0, "javarush", 500);
        CourseDto stepicDTO = new CourseDto(1, "stepic", 300);
        CourseDto lanitDTO = new CourseDto(2, "lanit", 100);
        List<CourseDto> expected = new ArrayList<>(Arrays.asList(javarushDTO, stepicDTO, lanitDTO));

        CourseDao courseDao = mock(CourseDao.class);
        when(courseDao.listCourses()).thenReturn(courses);


        CourseServiceImpl courseService = new CourseServiceImpl(courseDao,dozer);

        List<CourseDto> actual = courseService.findAllCourses();
        Assert.assertEquals(expected, actual);







//        List<CourseDto> actual = courseDto.getCourseDtoList(courses);
    }
}