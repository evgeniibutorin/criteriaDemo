package com.example.criteriademo.dao;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Course_;
import com.example.criteriademo.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        Query<Student> query = session.createQuery(cq);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> findStudentsByCoursesName(String courseName) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);// CriteriaQuery устанавливает функционал для запросов верхнего уровня
        Root<Course> courseRoot = cq.from(Course.class);//Root - корневой тип в from clause корни запросов всегда ссылаются на сущность
        cq.where(cb.equal(courseRoot.get(Course_.courseName), courseName));
        SetJoin<Course, Student> studentCourseSetJoin = courseRoot.join(Course_.students);
        CriteriaQuery<Student> studentCriteriaQuery = cq.select(studentCourseSetJoin);
        TypedQuery<Student> query = session.createQuery(studentCriteriaQuery);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> findStudentByCoursesCost(int cost) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);// CriteriaQuery устанавливает функционал для запросов верхнего уровня
        Root<Course> courseRoot = cq.from(Course.class);//Root - корневой тип в from clause корни запросов всегда ссылаются на сущность
        cq.where(cb.equal(courseRoot.get(Course_.courseCost), cost));
        SetJoin<Course, Student> studentCourseSetJoin = courseRoot.join(Course_.students);
        CriteriaQuery<Student> studentCriteriaQuery = cq.select(studentCourseSetJoin);
        TypedQuery<Student> query = session.createQuery(studentCriteriaQuery);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> findStudentWithExpensiveCourse(String cost) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);// CriteriaQuery устанавливает функционал для запросов верхнего уровня
        Root<Course> courseRoot = cq.from(Course.class);//Root - корневой тип в from clause корни запросов всегда ссылаются на сущность
        cq.where(cb.greaterThan(courseRoot.get("courseCost"), Integer.parseInt(cost)));
        SetJoin<Course, Student> studentCourseSetJoin = courseRoot.join(Course_.students);
        CriteriaQuery<Student> studentCriteriaQuery = cq.select(studentCourseSetJoin);
        TypedQuery<Student> query = session.createQuery(studentCriteriaQuery);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> findStudentInSomeList() {
        List<Integer> studentIdes = new ArrayList<>();
        for (int i = 0; i < 10003; i++) {
            studentIdes.add(i);
        }
        List<String> studentNames = new ArrayList<>(Arrays.asList("Max", "Jon", "Linda", "Pit", "Evelin"));
        Session session = this.sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Student.class, "st").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(
                Restrictions.and(
                        Restrictions.in("id", studentIdes)
                )
        );
        List<Student> students = c.list();
        return students;
    }
}
