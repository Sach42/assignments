package com.mappingpractice.mappings.Repository;

import com.mappingpractice.mappings.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
