package com.microservice.endpoint.service;

import java.util.List;


import com.microservice.core.repository.CourseRepository;
import com.microservice.core.model.Course;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService {

    @Autowired
    private final CourseRepository couserRepository;

    public List<Course> list(){
        log.info("Listing all cousers");
        return couserRepository.findAll();
    }
}
