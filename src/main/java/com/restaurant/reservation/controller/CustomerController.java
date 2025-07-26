package com.restaurant.reservation.controller;

import com.restaurant.reservation.dto.CustomerDTO;
import com.restaurant.reservation.dto.CustomerDTOIU;
import com.restaurant.reservation.entity.Customer;
import com.restaurant.reservation.mapper.CustomerMapper;
import com.restaurant.reservation.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;


    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        return customerMapper.toResponseDTO(customer);
    }

    @GetMapping("/phone/{phone}")
    public CustomerDTO getByPhone(@PathVariable String phone) {
    Customer customer = customerService.getCustomerByPhone(phone);
    return customerMapper.toResponseDTO(customer);
    }

    @GetMapping("/email/{email}")
    public CustomerDTO getByEmail(@PathVariable String email) {
    Customer customer = customerService.getCustomerByEmail(email);
    return customerMapper.toResponseDTO(customer);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomer() {
    List <Customer> customer = customerService.getAllCustomers();
    return customer.stream()
            .map(customerMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @PostMapping
    public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTOIU customerDTOIU) {
    Customer customer = customerMapper.toEntity(customerDTOIU);

    Customer savedCustomer = customerService.createCustomer(customer);

    return customerMapper.toResponseDTO(savedCustomer);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    }





}
