package com.example.criteriademo.config;

import com.example.criteriademo.dto.StudentDto;
import com.example.criteriademo.model.Student;
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