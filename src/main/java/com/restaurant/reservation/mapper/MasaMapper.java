package com.restaurant.reservation.mapper;

import com.restaurant.reservation.dto.MasaDTO;
import com.restaurant.reservation.dto.MasaDTOIU;
import com.restaurant.reservation.entity.Masa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MasaMapper {

    MasaDTO toResponseDTO(Masa masa);

    Masa toEntity(MasaDTOIU masaDTOIU);

    MasaDTOIU toRequestDTO(Masa masa);
}