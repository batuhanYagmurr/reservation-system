package com.restaurant.reservation.repository;

import com.restaurant.reservation.entity.Masa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MasaRepository extends JpaRepository<Masa, Long> {

    List<Masa> findByMasaNo(String masaNo);
    List<Masa> findByIsActiveTrue();



}
