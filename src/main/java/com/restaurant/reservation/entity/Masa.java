package com.restaurant.reservation.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "masalar")
public class Masa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String masaNo; //masa kodları b11,b12 vs vs vs

    @Column(nullable = false)
    private int capacity;

    private boolean isActive = true;





}
