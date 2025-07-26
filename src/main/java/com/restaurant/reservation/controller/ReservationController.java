package com.restaurant.reservation.controller;


import com.restaurant.reservation.dto.ReservationDTO;
import com.restaurant.reservation.dto.ReservationDTOIU;
import com.restaurant.reservation.entity.Reservation;
import com.restaurant.reservation.mapper.ReservationMapper;
import com.restaurant.reservation.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {


    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationMapper reservationMapper;


    @GetMapping
    public List<ReservationDTO> getAllReservation() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return reservations.stream()
                .map(reservationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/date/{date}")
    public List<ReservationDTO> getReservationsByDate(@PathVariable LocalDate date) {
        List<Reservation> reservations = reservationService.getReservationsByDate(date);
        return reservations.stream()
                .map(reservationMapper::toResponseDTO)
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public ReservationDTO getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        return reservationMapper.toResponseDTO(reservation);
    }

    @GetMapping("/customer/{customerId}")
    public List<ReservationDTO> getReservationByCustomer(@PathVariable Long customerId) {
        List<Reservation> reservations = reservationService.getReservationsByCustomerId(customerId);
        return reservations.stream()
                .map(reservationMapper::toResponseDTO)
                .collect(Collectors.toList());

    }


    @PostMapping
    public ReservationDTO createReservation(@Valid @RequestBody ReservationDTOIU reservationDTOIU) {
        Reservation reservation = reservationMapper.toEntity(reservationDTOIU);
        Reservation savedReservation = reservationService.createReservation(reservation);

        return reservationMapper.toResponseDTO(savedReservation);
    }

    @PutMapping("/{id}/cancel")
    public ReservationDTO cancelReservation(@PathVariable Long id) {
        Reservation cancelledReservation = reservationService.cancelReservation(id);
        return reservationMapper.toResponseDTO(cancelledReservation);
    }


}