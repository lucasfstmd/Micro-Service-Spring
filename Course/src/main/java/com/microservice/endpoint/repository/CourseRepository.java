package com.microservice.endpoint.repository;

import com.microservice.endpoint.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
