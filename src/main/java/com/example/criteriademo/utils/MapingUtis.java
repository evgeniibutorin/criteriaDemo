//package com.example.criteriademo.utils;
//
//import com.example.criteriademo.dto.CourseDto;
//import com.example.criteriademo.dto.StudentDto;
//import com.example.criteriademo.model.Course;
//import com.example.criteriademo.model.Student;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MapingUtis {
//
//    public StudentDto mapToStudentDto(Student student){
//        StudentDto dto = new StudentDto();
//        dto.setId(student.getId());
//        dto.setStudentName(student.getStudentName());
//        dto.setCourses(student.getCourses());
//        return dto;
//    }
//
//    public Student mapToStudent(StudentDto dto){
//        Student student = new Student();
//        student.setId(dto.getId());
//        student.setStudentName(dto.getStudentName());
//        student.setCourses(dto.getCourses());
//        return student;
//    }
//
//    public CourseDto mapToCourseDTo(Course course){
//        CourseDto dto = new CourseDto();
//        dto.setId(course.getId());
//        dto.setCourseName(course.getCourseName());
//        dto.setCourseCost(course.getCourseCost());
//        dto.setCourseCost(course.getCourseCost());
//        dto.setStudents(course.getStudents());
//        return dto;
//    }
//
//    public Course mapToCourse(CourseDto dto){
//        Course course = new Course();
//        course.setId(dto.getId());
//        course.setCourseName(dto.getCourseName());
//        course.setCourseCost(dto.getCourseCost());
//        course.setStudents(dto.getStudents());
//        return course;
//    }
//
//
//}
