package com.restaurant.reservation.dto;

import com.restaurant.reservation.entity.ReservationStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTOIU {


    @NotNull(message = "Customer ID Bos olamaz.")
    private Long id;

    @NotNull(message = "Masa ID boş olamaz")
    private Long masaID;

    @NotNull(message = "Rezervazton tarihi boş olamaz")
    @Future(message = "ezervasyon tarihi gelecek bir tarih olmalıdır")
    private LocalDate reservationDate;

    @Min(value = 1,message = "Kisi sayisi en az 1 olmalıdır.")
    private int numberOfPeople;

    private ReservationStatus status = ReservationStatus.CONFIRMED;

}
