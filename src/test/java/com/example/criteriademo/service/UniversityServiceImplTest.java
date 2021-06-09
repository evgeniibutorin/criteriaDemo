package com.example.criteriademo.service;

import com.example.criteriademo.dao.UniversityDao;
import com.example.criteriademo.model.University;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

@ContextConfiguration({"file:src/test/resources/spring-mvc-config.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UniversityServiceImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UniversityDao universityDao;

    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = webApplicationContext.getServletContext();
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
//        Assert.assertNotNull(webApplicationContext.getBean("greetController"));

    }

    @Test
    public void save() {

        University university = new University(3, "PSU", 130);
        universityDao.saveOne(university);
        University university1 = universityDao.getOne(3);
        //todo: delete next line
        System.out.println("Before bug");
        Assert.assertEquals("PSU", university1.getUniversityName());
    }
}