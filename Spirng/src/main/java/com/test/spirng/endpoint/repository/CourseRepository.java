package com.test.spirng.endpoint.repository;

import com.test.spirng.endpoint.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
