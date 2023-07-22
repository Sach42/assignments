package com.hotelmanage.hotelmanagement.model;

import com.hotelmanage.hotelmanagement.model.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class HotelRoom {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private Integer roomno;

    @Column
    private Double roomPrice;

    @Column
    private Boolean roomStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private Type roomType;

}
