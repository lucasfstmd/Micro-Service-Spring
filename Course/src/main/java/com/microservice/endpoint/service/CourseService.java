package com.microservice.endpoint.service;

import java.util.List;

import com.microservice.endpoint.model.Course;
import com.microservice.endpoint.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CourseService {

    @Autowired
    private CourseRepository couserRepository;

    public List<Course> list(){
        log.info("Listing all cousers");
        return couserRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
