package com.example.criteriademo.dao;

import com.example.criteriademo.model.Course;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Course> listCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Course.class);
        List<Course> courses = criteria.list();
        return courses;
    }

    @Override
    public List<Course> findCoursesByStudentName(String studentName) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Course.class, "cr");
        criteria.createAlias("cr.students", "st");//createAlias эквивалент join. первым параметром указываем имя поля в сущности вторым псевдоним
        criteria.add(Restrictions.eq("st.studentName", studentName));//Restrictions.eq сравнивает переданные параметры
        List<Course> courses = criteria.list();
        return courses;
    }
}

