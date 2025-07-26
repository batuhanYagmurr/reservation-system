package com.restaurant.reservation.controller;

import com.restaurant.reservation.dto.MasaDTO;
import com.restaurant.reservation.dto.MasaDTOIU;
import com.restaurant.reservation.entity.Masa;
import com.restaurant.reservation.mapper.MasaMapper;
import com.restaurant.reservation.service.MasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/masalar")
public class MasaController {

    @Autowired
    private MasaService masaService;

    @Autowired
    private MasaMapper masaMapper;

    @GetMapping
    public List<MasaDTO> getAllMasalar() {
        List<Masa> masalar = masaService.getAllMasalar();
        return masalar.stream()
                .map(masaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MasaDTO getMasaById(@PathVariable Long id) {
        Masa masa = masaService.getMasaById(id);
        return masaMapper.toResponseDTO(masa);
    }

    @GetMapping("/masa-no/{masaNo}")
    public MasaDTO getMasaByMasaNo(@PathVariable String masaNo) {
        Masa masa = masaService.getMasaByMasaNo(masaNo);
        return masaMapper.toResponseDTO(masa);
    }

    @PostMapping
    public MasaDTO createMasa(@Valid @RequestBody MasaDTOIU masaDTOIU) {

        Masa masa = masaMapper.toEntity(masaDTOIU);

        Masa savedMasa = masaService.createMasa(masa);

        return masaMapper.toResponseDTO(savedMasa);
    }

    @GetMapping("/active")
    public List<MasaDTO> getActiveMasalar() {
        List<Masa> activeMasalar = masaService.getAllActiveMasalar();
        return activeMasalar.stream()
                .map(masaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}