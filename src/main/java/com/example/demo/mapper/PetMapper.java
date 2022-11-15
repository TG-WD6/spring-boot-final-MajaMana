package com.example.demo.mapper;

import com.example.demo.dto.PetDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Pet;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.request.PetRequest;
import com.example.demo.response.PetResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class PetMapper {

    @Autowired
    private static CustomerRepository customerRepository;

    public static PetResponse toPetResponse(Pet pet) {
        return new PetResponse()
                .setName(pet.getName())
                .setType(pet.getType().getName())
                .setOwner(pet.getOwner().getName());
    }

    public static Pet toPet(PetRequest petRequest) {
        Pet pet = new Pet().setName(petRequest.getName());
         // .setType(repository.findByName(petRequest.getType())
        Customer owner = customerRepository.findById(petRequest.getCustomer_id()).get();
        pet.setOwner(owner);
        return pet;
    }
}
