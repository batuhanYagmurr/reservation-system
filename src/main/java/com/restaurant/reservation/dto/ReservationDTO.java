package com.restaurant.reservation.dto;

import com.restaurant.reservation.entity.ReservationStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO {

    private Long id;
    private LocalDate reservationDate;
    private int numberOfPeople;
    private ReservationStatus status;


    private CustomerDTO customer;

    private MasaDTO masa;


}
