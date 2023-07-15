package com.mappingpractice.mappings.Repository;

import com.mappingpractice.mappings.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
