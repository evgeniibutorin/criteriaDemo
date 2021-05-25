package com.example.criteriademo.dao;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
        Criteria criteria = session.createCriteria(Student.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Student> students = criteria.list();
        return students;
    }

    @Override
    public List<Student> findStudentsByCoursesName(String courseName) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Student.class, "st").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//setResultTransformer что бы сущности не возвращались по несколько раз
        criteria.createAlias("st.courses", "cr");//createAlias эквивалент join. первым параметром указываем имя поля в сущности вторым псевдоним
        criteria.add(Restrictions.eq("cr.courseName", courseName));//Restrictions.eq сравнивает переданные параметры
        List<Student> students = criteria.list();
        return students;
    }

    @Override
    public List<Student> findStudentByCoursesCost(int cost) {
        Session session = this.sessionFactory.getCurrentSession();
        Type type = IntegerType.INSTANCE;
        Integer integer = cost;
        Criteria criteria = session.createCriteria(Student.class, "st").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.createAlias("st.courses", "cr");
        criteria.add(Restrictions.sqlRestriction("exists(\n" +
                "    select cr2.ID\n" +
                "    from course cr2\n" +
                "    where course_cost = ?\n" +
                "        AND cr1_.id=cr2.id)", integer, type));
        List<Student> students = criteria.list();
        return students;
    }

    @Override
    public List<Student> findStudentWithExpensiveCourse(String cost) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Student.class, "st").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        DetachedCriteria dc = DetachedCriteria.forClass(Course.class, "cr");
        dc.createAlias("cr.students", "st2");
        dc.add(Restrictions.ge("cr.courseCost", Integer.parseInt(cost)));
        dc.setProjection(Projections.property("st2.id"));

        c.add(Subqueries.propertyIn("st.id", dc));
        List<Student> students = c.list();
        return students;
    }

    @Override
    public List<Student> findStudentInSomeList() {
        List<Integer> studentIdes = new ArrayList<>();
        for (int i=0; i<10003; i++){
            studentIdes.add(i);
        }
        List<String> studentNames = new ArrayList<>(Arrays.asList( "Max", "Jon", "Linda", "Pit", "Evelin"));
        Session session = this.sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Student.class, "st").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(
                Restrictions.and(
                        Restrictions.in("id",studentIdes)
                )
        );
        List<Student> students = c.list();
        return students;
    }


//    @Override
//    public List<Student> findStudentInSomeList() {
//        List<String> studentNames = new ArrayList<>(Arrays.asList( "Max", "Jon", "Linda", "Pit", "Evelin"));
//        Session session = this.sessionFactory.getCurrentSession();
//        Criteria c = session.createCriteria(Student.class, "st").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(
//                Restrictions.and(
//                        Restrictions.in("studentName", studentNames)
//                )
//        );
//        List<Student> students = c.list();
//        return students;
//    }
}
