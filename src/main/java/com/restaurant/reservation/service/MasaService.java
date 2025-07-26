package com.restaurant.reservation.service;

import com.restaurant.reservation.entity.Masa;
import com.restaurant.reservation.repository.MasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasaService {

    @Autowired
    private MasaRepository masaRepository;

    public List<Masa> getAllMasalar() {
        return masaRepository.findAll();
    }

    public List<Masa> getAllActiveMasalar() {
        return masaRepository.findByIsActiveTrue();
    }

    public Masa getMasaById(Long id) {
        return masaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Masa bulunamadi: " + id));
    }

    public Masa getMasaByMasaNo(String masaNo) {
        List<Masa> masalar = masaRepository.findByMasaNo(masaNo);
        if (masalar.isEmpty()) {
            throw new RuntimeException("Masa bulunamadi: " + masaNo);
        }
        return masalar.get(0);
    }

    public Masa createMasa(Masa masa) {

        return masaRepository.save(masa);
    }
}