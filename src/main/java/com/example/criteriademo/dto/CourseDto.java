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
public class CourseDto {

    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String courseName;

    @Getter
    @Setter
    int cost;

    @Getter
    @Setter
    Set<StudentDto> students = new HashSet<>();


    public List<CourseDto> getCourseDtoList(List<Course> courseSet){
        List<CourseDto> courseDtoSet = new ArrayList<>();
        for (Course course:courseSet){
            students = new HashSet<>();
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setCourseName(course.getCourseName());
            for (Student student:course.getStudents()){
                StudentDto studentDto = new StudentDto();
                studentDto.setId(student.getId());
                studentDto.setStudentName(student.getStudentName());
                students.add(studentDto);
            }
            courseDto.setStudents(students);
            courseDtoSet.add(courseDto);
        }
        return courseDtoSet;
    }

}

