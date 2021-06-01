package com.example.criteriademo.dto;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
public class StudentDto {

    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String studentName;

    @Getter
    @Setter
    Set<Course> courses;

//    public Set<StudentDto> getStudentDtoSet(Set<Student> studentSet){
//        Set<StudentDto> studentDtoSet = new HashSet<>();
//        for (Student student:studentSet){
//            courses = new HashSet<>();
//            StudentDto studentDto = new StudentDto();
//            studentDto.setId(student.getId());
//            studentDto.setStudentName(student.getStudentName());
//            for (Course course:student.getCourses()){
//                CourseDto courseDto = new CourseDto();
//                courseDto.setId(course.getId());
//                courseDto.setCourseName(course.getCourseName());
//                courseDto.setCost(course.getCourseCost());
//                courses.add(courseDto);
//            }
//            studentDto.setCourses(courses);
//            studentDtoSet.add(studentDto);
//        }
//        return studentDtoSet;
//    }
}
