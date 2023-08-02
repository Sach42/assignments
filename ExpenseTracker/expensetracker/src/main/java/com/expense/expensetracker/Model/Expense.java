package com.expense.expensetracker.Model;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
    private double price;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public double getAmount() {
        return price;
    }
}