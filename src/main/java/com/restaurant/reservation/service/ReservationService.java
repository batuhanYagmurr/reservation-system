package com.restaurant.reservation.service;

import com.restaurant.reservation.entity.Reservation;
import com.restaurant.reservation.entity.ReservationStatus;
import com.restaurant.reservation.repository.CustomerRepository;
import com.restaurant.reservation.repository.MasaRepository;
import com.restaurant.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {


    private final ReservationRepository reservationRepository;
    private final MasaRepository masaRepository;
    private final CustomerRepository customerRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByCustomerId(Long customerId) {
        return reservationRepository.findByCustomerId(customerId);
    }

    public List<Reservation> getReservationsByStatus(ReservationStatus status) {
        return reservationRepository.findByStatus(status);
    }

    public List<Reservation> getReservationsByDate(LocalDate date) {
        return reservationRepository.findByReservationDate(date);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation cancelReservation(Long id) {
        Reservation reservation = getReservationById(id);
        if (reservation == null) {
            return null;
        }
        reservation.setStatus(ReservationStatus.CANCELLED);
        return reservationRepository.save(reservation);

    }



}
