package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.PetDTO;
import com.example.demo.model.Pet;
import com.example.demo.request.PetRequest;
import com.example.demo.response.PetResponse;
import com.example.demo.service.CustomerService;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private PetService petService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/pets")
    public List<PetResponse> getPets(@RequestParam(required = false) String name) {
        if (name != null) {
            return petService.getPetsByName(name);
        }
        return petService.getAllPets();
    }

    @PostMapping("/pets/new")
    public ResponseEntity<Void> createPet(@RequestBody PetRequest petRequest) {
        return petService.createPet(petRequest);
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<PetResponse> getPet(@PathVariable Long id) {
        return petService.getPet(id);
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<Void> updatePet(@PathVariable Long id, @RequestBody PetRequest petRequest) {
        return petService.updatePet(id, petRequest);
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<Void> removePet(@PathVariable Long id) {
        return petService.removePet(id);
    }

    @GetMapping("/owners")
    public List<CustomerDTO> getCustomers(@RequestParam(required = false) String name) {
        if (name != null) {
            return customerService.getCustomersByName(name);
        }
        return customerService.getAllCustomers();
    }
//
//    @PostMapping("/owners/new")
//    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDTO customerDTO) {
//        return customerService.createCustomer(customerDTO);
//    }
//
//    @GetMapping("/owners/{id}")
//    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
//        return customerService.getCustomer(id);
//    }
//
//    @PutMapping("/owners/{id}")
//    public ResponseEntity<Void> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
//        return customerService.updateCustomer(id, customerDTO);
//    }
//
//    @DeleteMapping("/owners/{id}")
//    public ResponseEntity<Void> removeCustomer(@PathVariable Long id) {
//        return customerService.removeCustomer(id);
//    }
}
