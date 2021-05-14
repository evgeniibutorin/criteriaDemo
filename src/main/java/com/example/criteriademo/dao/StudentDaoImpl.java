package com.example.criteriademo.dao;

import com.example.criteriademo.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;



    @Override
    @Transactional
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Student.class);
        List<Student> students = criteria.list();
        return students;
    }
}
