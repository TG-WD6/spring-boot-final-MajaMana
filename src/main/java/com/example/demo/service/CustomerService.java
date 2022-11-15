package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::toCustomerDTO).toList();
    }

    public ResponseEntity<CustomerDTO> getCustomer(Long id) {
        try {
            Customer customer = customerRepository.findById(id).orElseThrow();
            return ResponseEntity.ok(CustomerMapper.toCustomerDTO(customer));
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> updateCustomer(Long id, CustomerDTO customerDTO) {
        try {
            Customer customer = customerRepository.findById(id).orElseThrow();
            customer.setName(customerDTO.getName());
            customerRepository.save(customer);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> removeCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> createCustomer(CustomerDTO customerDTO) {
        try {
            Customer customer = CustomerMapper.toCustomer(customerDTO);
            customerRepository.save(customer);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public List<CustomerDTO> getCustomersByName(String name) {
        return customerRepository.findByName(name).stream().map(CustomerMapper::toCustomerDTO).toList();
    }
}
