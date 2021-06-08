package com.example.criteriademo.dao;

import com.example.criteriademo.model.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UniversityDaoImpl implements UniversityDao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<University> listUniversity() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<University> cq = cb.createQuery(University.class);
        Root<University> root = cq.from(University.class);
        cq.select(root);
        Query<University> query = session.createQuery(cq);
        List<University> students = query.getResultList();
        return students;
    }

    @Override
    public University saveOne(University university) {
        Session session = this.sessionFactory.openSession();

        session.save(university);

//        Query query = session.createSQLQuery("insert into university (id, university_name, university_rating) VALUES (:1,:2,:3)")
//                .setParameter("1", university.getId())
//                .setParameter("2",university.getUniversityName())
//                .setParameter("3", university.getRating());
//        query.executeUpdate();
        return university;
    }

    @Override
    public University getOne(int id) {
        Session session = this.sessionFactory.openSession();
        return (University) session.get(University.class, id);
    }
}
