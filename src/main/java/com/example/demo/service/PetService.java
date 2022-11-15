package com.example.demo.service;

import com.example.demo.dto.PetDTO;
import com.example.demo.mapper.PetMapper;
import com.example.demo.model.Pet;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PetRepository;
import com.example.demo.request.PetRequest;
import com.example.demo.response.PetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<PetResponse> getAllPets() {
        return petRepository.findAll().stream().map(PetMapper::toPetResponse).toList();
    }

    public ResponseEntity<PetResponse> getPet(Long id) {
        try {
            Pet pet = petRepository.findById(id).orElseThrow();
            return ResponseEntity.ok(PetMapper.toPetResponse(pet));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> updatePet(Long id, PetRequest petRequest) {
        try {
            Pet pet = petRepository.findById(id).orElseThrow();
            pet.setName(petRequest.getName());
//            pet.setType ???
            pet.setOwner(customerRepository.findById(petRequest.getCustomer_id()).orElseThrow());
            petRepository.save(pet);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> removePet(Long id) {
        try {
            petRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> createPet(PetRequest petRequest) {
        try {
            Pet pet = PetMapper.toPet(petRequest);
            petRepository.save(pet);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public List<PetResponse> getPetsByName(String name) {
        return petRepository.findByName(name).stream().map(PetMapper::toPetResponse).toList();
    }
}
