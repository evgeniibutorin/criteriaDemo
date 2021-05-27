package com.example.criteriademo.dao;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import com.example.criteriademo.model.Student_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Course> listCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        cq.select(root);
        Query<Course> query = session.createQuery(cq);
        List<Course> results = query.getResultList();
        return results;
    }

    @Override
    public List<Course> findCoursesByStudentName(String studentName) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class); // CriteriaQuery устанавливает функционал для запросов верхнего уровня
        Root<Student> studentRoot = criteriaQuery.from(Student.class);//Root - корневой тип в from clause корни запросов всегда ссылаются на сущность
        criteriaQuery.where(criteriaBuilder.equal(studentRoot.get(Student_.studentName), studentName));
        SetJoin<Student, Course> studentCourseSetJoin = studentRoot.join(Student_.courses);
        CriteriaQuery<Course> cq = criteriaQuery.select(studentCourseSetJoin);
        TypedQuery<Course> query = session.createQuery(cq);
        List<Course> courses = query.getResultList();
        return courses;
    }


    //select course from course where course_cost = (SELECT MAX(course.course_cost) from course);

    @Override
    public List<Course> findExpensiveCourse() {

        //select course from course
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> course = criteriaQuery.from(Course.class);

        //SELECT MAX(course.course_cost) from course
        Subquery<Integer> subQuery = criteriaQuery.subquery(Integer.class);
        Root<Course> cost = subQuery.from(Course.class);
        subQuery.select(criteriaBuilder.max(cost.<Integer>get("courseCost")));

        //where course_cost =
        criteriaQuery.where(criteriaBuilder.equal(course.get("courseCost"),subQuery));
        Query<Course> query = session.createQuery(criteriaQuery);
        List<Course> results = query.getResultList();
        return results;
    }


}

