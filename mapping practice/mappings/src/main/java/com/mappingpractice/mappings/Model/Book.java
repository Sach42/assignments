package com.mappingpractice.mappings.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String BookID;
    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    private Student student;
}


