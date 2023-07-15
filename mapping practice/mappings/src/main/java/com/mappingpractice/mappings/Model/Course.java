package com.mappingpractice.mappings.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private String CourseId;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    List<Student> studentList;
}


