package com.microservice.endpoint.controller;

import com.microservice.core.model.Course;
import com.microservice.endpoint.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/admin/course")
@Slf4j
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> list(){
        return new ResponseEntity<>(courseService.list(), HttpStatus.OK);
    }
}
