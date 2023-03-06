package com.microservice.endpoint.controller;

import com.microservice.core.model.Course;
import com.microservice.endpoint.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Endpoints to manage course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/course")
    @ApiOperation(value = "List all available courses", response = Course[].class)
    public ResponseEntity<List<Course>> list(){
        return new ResponseEntity<>(courseService.list(), HttpStatus.OK);
    }
}
