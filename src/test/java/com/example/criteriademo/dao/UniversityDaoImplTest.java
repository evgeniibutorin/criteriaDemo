//package com.example.criteriademo.dao;
//
//import com.example.criteriademo.model.University;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.*;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"file:src/test/webapp/WEB-INF/spring-mvc-config.xml"})
//@Transactional
//public class UniversityDaoImplTest {
//    @Autowired
//    @Qualifier("sessionFactory")
//    private SessionFactory sessionFactory;
//
//    University university = new University(0,"PSU", 100);
//
//    @Test
//    public void saveOne() {
//        Session session = this.sessionFactory.openSession();
//        return (University) session.get(University.class,id);
//    }
//}