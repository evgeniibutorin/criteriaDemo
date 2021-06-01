package com.example.criteriademo.dto;

import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    Set<CourseDto> courses;

    public List<StudentDto> getStudentDtoList(List<Student> studentSet){
        List<StudentDto> studentDtoSet = new ArrayList<>();
        for (Student student:studentSet){
            courses = new HashSet<>();
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setStudentName(student.getStudentName());
            for (Course course:student.getCourses()){
                CourseDto courseDto = new CourseDto();
                courseDto.setId(course.getId());
                courseDto.setCourseName(course.getCourseName());
                courseDto.setCost(course.getCourseCost());
                courses.add(courseDto);
            }
            studentDto.setCourses(courses);
            studentDtoSet.add(studentDto);
        }
        return studentDtoSet;
    }
}
