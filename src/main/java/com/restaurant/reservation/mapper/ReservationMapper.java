package com.restaurant.reservation.mapper;

import com.restaurant.reservation.dto.ReservationDTO;
import com.restaurant.reservation.dto.ReservationDTOIU;
import com.restaurant.reservation.entity.Customer;
import com.restaurant.reservation.entity.Masa;
import com.restaurant.reservation.entity.Reservation;
import com.restaurant.reservation.service.CustomerService;
import com.restaurant.reservation.service.MasaService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, MasaMapper.class})
public abstract class ReservationMapper {

    @Autowired
    protected CustomerService customerService;

    @Autowired
    protected MasaService masaService;

    public abstract ReservationDTO toResponseDTO(Reservation reservation);


    public Reservation toEntity(ReservationDTOIU reservationDTOIU) {
        Reservation reservation = new Reservation();

        reservation.setReservationDate(reservationDTOIU.getReservationDate());
        reservation.setNumberOfPeople(reservationDTOIU.getNumberOfPeople());
        reservation.setStatus(reservationDTOIU.getStatus());


        Customer customer = customerService.getById(reservationDTOIU.getId());
        Masa masa = masaService.getMasaById(reservationDTOIU.getMasaID());

        reservation.setCustomer(customer);
        reservation.setMasa(masa);

        return reservation;
    }

    @Mapping(target = "masaID", source = "masa.id")
    @Mapping(target = "id", source = "customer.id")
    public abstract ReservationDTOIU toRequest(Reservation reservation);
}