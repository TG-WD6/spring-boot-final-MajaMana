package com.example.demo.mapper;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;

public class CustomerMapper {

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO()
                .setName(customer.getName())
                .setPetList(customer.getPetList().stream().map(PetMapper::toPetDTO).toList())
                .setUsername(customer.getUsername());
    }

    public static Customer toCustomer(CustomerDTO customerDTO) {
        return new Customer()
                .setName(customerDTO.getName())
                .setUsername(customerDTO.getUsername());
    }
}
