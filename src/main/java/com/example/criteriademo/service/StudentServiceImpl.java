package com.example.criteriademo.service;

import com.example.criteriademo.dao.StudentDAO;
import com.example.criteriademo.model.Student;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAllStudent() {
        List<Student> students = studentDAO.listStudents();
        for (Student student : students) {
//            student.getCourses();
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

}
