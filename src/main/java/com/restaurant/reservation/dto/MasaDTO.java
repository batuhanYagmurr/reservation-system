package com.restaurant.reservation.dto;

import lombok.Data;

@Data
public class MasaDTO {

    private Long id;
    private String masaNo;
    private int capacity;
    private boolean isActive;
}
