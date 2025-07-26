package com.restaurant.reservation.mapper;

import com.restaurant.reservation.dto.CustomerDTO;
import com.restaurant.reservation.dto.CustomerDTOIU;
import com.restaurant.reservation.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toResponseDTO(Customer customer);

    Customer toEntity(CustomerDTOIU customerDTOIU);

    CustomerDTOIU toRequestDTO(Customer customer);
}