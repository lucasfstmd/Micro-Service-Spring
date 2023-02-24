package com.test.spirng.endpoint.controller;

import com.test.spirng.endpoint.model.Course;
import com.test.spirng.endpoint.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/admin/services")
@Slf4j
public class CourseController {

    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> list(){
        return new ResponseEntity<>(courseService.list(), HttpStatus.OK);
    }
}
