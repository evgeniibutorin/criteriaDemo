package com.example.criteriademo.dto;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CourseDtoTest {

    @Test
    public void getCourseDtoList() {

        CourseDto courseDto = new CourseDto();

        Student max = new Student(0,"Max",null);
        Student jon = new Student(1,"Jon",null);
        Student linda = new Student(2,"Linda",null);
        Set<Student> studentsJavarush = new HashSet<>(Arrays.asList(max,jon));
        Set<Student> studentsStepic = new HashSet<>(Arrays.asList(max,jon,linda));
        Set<Student> studentsLanit = new HashSet<>(Arrays.asList(max,linda));
        Course javarush = new Course(0,"javarush",500,studentsJavarush);
        Course stepic = new Course(1,"stepic",300,studentsStepic);
        Course lanit = new Course(2,"lanit",100,studentsLanit);
        List<Course> courses = new ArrayList<>(Arrays.asList(javarush,stepic,lanit));

        StudentDto maxDTO = new StudentDto(0,"Max",null);
        StudentDto jonDTO = new StudentDto(1,"Jon",null);
        StudentDto lindaDTO = new StudentDto(2,"Linda",null);
        Set<StudentDto> studentsJavarushDTO = new HashSet<>(Arrays.asList(maxDTO,jonDTO));
        Set<StudentDto> studentsStepicDTO = new HashSet<>(Arrays.asList(maxDTO,jonDTO,lindaDTO));
        Set<StudentDto> studentsLanitDTO = new HashSet<>(Arrays.asList(maxDTO,lindaDTO));
        CourseDto javarushDTO = new CourseDto(0,"javarush",600,studentsJavarushDTO);
        CourseDto stepicDTO = new CourseDto(1,"stepic",400,studentsStepicDTO);
        CourseDto lanitDTO = new CourseDto(2,"lanit",200,studentsLanitDTO);

        List<CourseDto> expected = new ArrayList<>(Arrays.asList(javarushDTO,stepicDTO,lanitDTO));
        List<CourseDto> actual = courseDto.getCourseDtoList(courses);

        Assert.assertEquals(expected, actual);

    }
}