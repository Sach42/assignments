package com.mappingpractice.mappings.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id
    private String LaptopId;
    private String name;

    private String brand;
    private Integer price;

    @OneToOne
    private Student student;

}
