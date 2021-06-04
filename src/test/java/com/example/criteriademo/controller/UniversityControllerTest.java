package com.example.criteriademo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-mvc-crud-demo-servlet.xml"})
@WebAppConfiguration
public class UniversityControllerTest {
    CourseController courseController;
    @Test
    public void test1(){
        String expected = "test1";
        String actual = courseController.test1();
        assertEquals(expected,actual);
    }

}