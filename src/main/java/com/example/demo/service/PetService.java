package com.example.demo.service;

import com.example.demo.dto.PetDTO;
import com.example.demo.mapper.PetMapper;
import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<PetDTO> getAllPets() {
        return petRepository.findAll().stream().map(PetMapper::toPetDTO).toList();
    }

    public ResponseEntity<PetDTO> getPet(Long id) {
        try {
            Pet pet = petRepository.findById(id).orElseThrow();
            return ResponseEntity.ok(PetMapper.toPetDTO(pet));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> updatePet(Long id, PetDTO petDTO) {
        try {
            Pet pet = petRepository.findById(id).orElseThrow();
            pet.setName(petDTO.getName());
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

    public ResponseEntity<Void> createPet(PetDTO petDTO) {
        try {
            Pet pet = PetMapper.toPet(petDTO);
            petRepository.save(pet);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public List<PetDTO> getPetsByName(String name) {
        return petRepository.findByName(name).stream().map(PetMapper::toPetDTO).toList();
    }
}
