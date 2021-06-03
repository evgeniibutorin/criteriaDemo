package com.example.criteriademo.dto;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StudentDtoTest {

    @Test
    public void getStudentDtoList() {

            StudentDto studentDto = new StudentDto();
            Course javarush = new Course(0, "javarush", 500, null);
            Course stepic = new Course(1, "stepic", 300, null);
            Course lanit = new Course(2, "lanit", 100, null);
            Set<Course> maxCourses = new HashSet<>(Arrays.asList(javarush, stepic, lanit));
            Set<Course> jonCourses = new HashSet<>(Arrays.asList(javarush, stepic));
            Set<Course> lindaCourses = new HashSet<>(Arrays.asList(stepic, lanit));
            Student max = new Student(0, "Max", maxCourses);
            Student jon = new Student(1, "Jon", jonCourses);
            Student linda = new Student(2, "Linda", lindaCourses);
            List<Student> students = new ArrayList<>(Arrays.asList(max, jon, linda));

            CourseDto javarushDTO = new CourseDto(0, "javarush", 600, null);
            CourseDto stepicDTO = new CourseDto(1, "stepic", 400, null);
            CourseDto lanitDTO = new CourseDto(2, "lanit", 200, null);
            Set<CourseDto> courseMaxDTO = new HashSet<>(Arrays.asList(javarushDTO, stepicDTO, lanitDTO));
            Set<CourseDto> courseJonDTO = new HashSet<>(Arrays.asList(javarushDTO, stepicDTO));
            Set<CourseDto> courseLindaDTO = new HashSet<>(Arrays.asList(stepicDTO, lanitDTO));
            StudentDto maxDTO = new StudentDto(0, "Max", courseMaxDTO);
            StudentDto jonDTO = new StudentDto(1, "Jon", courseJonDTO);
            StudentDto lindaDTO = new StudentDto(2, "Linda", courseLindaDTO);

            List<StudentDto> expected = new ArrayList<>(Arrays.asList(maxDTO, jonDTO, lindaDTO));
            List<StudentDto> actual = studentDto.getStudentDtoList(students);

            Assert.assertEquals(expected, actual);

    }
}