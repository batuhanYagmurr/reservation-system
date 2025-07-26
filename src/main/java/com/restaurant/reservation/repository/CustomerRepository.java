package com.restaurant.reservation.repository;

import com.restaurant.reservation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    List<Customer> findByNameIgnoreCase(String name);
    List<Customer> findBySurnameIgnoreCase(String surname);
    Optional<Customer> findByPhone(String phone);
}
