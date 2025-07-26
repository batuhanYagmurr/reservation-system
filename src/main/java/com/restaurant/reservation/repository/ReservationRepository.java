package com.restaurant.reservation.repository;

import com.restaurant.reservation.entity.Customer;
import com.restaurant.reservation.entity.Reservation;
import com.restaurant.reservation.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByCustomerId(Long id);
    List<Reservation> findByStatus(ReservationStatus status);
    List<Reservation> findByReservationDate(LocalDate reservationDate);
    List<Reservation> findByMasaIdAndReservationDate(Long masaId, LocalDate reservationDate);



   // boolean existsByMasaIdAndReservationDateAndReservationTime(
     //       Long masaId, LocalDate date, LocalTime time);


}
