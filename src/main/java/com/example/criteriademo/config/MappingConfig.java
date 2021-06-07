package com.example.criteriademo.config;

import com.example.criteriademo.dto.CourseDto;
import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.dto.UniversityDto;
import com.example.criteriademo.model.Course;
import com.example.criteriademo.model.Student;
import com.example.criteriademo.model.University;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    public BeanMappingBuilder beanMappingBuilder(){
       return new BeanMappingBuilder() {
           @Override
           protected void configure() {
               mapping(Student.class, StudentDto.class);
               mapping(University.class, UniversityDto.class);
               mapping(Course.class, CourseDto.class);
           }
       };
    }
    @Bean
    public DozerBeanMapper beanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(beanMappingBuilder());
        return dozerBeanMapper;
    }

}