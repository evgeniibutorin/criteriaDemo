package com.example.criteriademo.service;

import com.example.criteriademo.dao.StudentDAO;
import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.model.Student;
import org.dozer.DozerBeanMapper;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;
    private final DozerBeanMapper beanMapper;

    public StudentServiceImpl(StudentDAO studentDAO, DozerBeanMapper beanMapper) {
        this.studentDAO = studentDAO;
        this.beanMapper = beanMapper;
    }

    @Override
    @Transactional
    public List<Student> findAllStudent() {
        List<Student> students = studentDAO.listStudents();
        for (Student student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

    @Override
    @Transactional
    public List<StudentDto> getStudentByCourseName(String name) {
        List<StudentDto> students = studentDAO.findStudentsByCoursesName(name).stream()
                .map(student -> beanMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
        for (StudentDto student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

    @Override
    @Transactional
    public List<StudentDto> findStudentByCoursesCost(int cost) {
        List<StudentDto> students = studentDAO.findStudentByCoursesCost(cost).stream()
                .map(student -> beanMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
        for (StudentDto student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

    @Override
    @Transactional
    public List<StudentDto> getStudentsWithExpensiveCourse(String cost) {
        List<StudentDto> students = studentDAO.findStudentWithExpensiveCourse(cost).stream()
                .map(student -> beanMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
        for (StudentDto student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

    @Override
    @Transactional
    public List<StudentDto> getStudentInList() {
        List<StudentDto> students = studentDAO.findStudentInSomeList().stream()
                .map(student -> beanMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
        for (StudentDto student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

}
