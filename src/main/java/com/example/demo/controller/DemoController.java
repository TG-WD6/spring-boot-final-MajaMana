package com.example.demo.controller;

import com.example.demo.dto.PetDTO;
import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private PetService petService;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/pets")
    public List<PetDTO> getPets(@RequestParam(required = false) String name) {
        if (name != null) {
            return petService.getPetsByName(name);
        }
        return petService.getAllPets();
    }

    @PostMapping("/pets/new")
    public ResponseEntity<Void> createPet(@RequestBody PetDTO petDTO) {
        return petService.createPet(petDTO);
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<PetDTO> getPet(@PathVariable Long id) {
        return petService.getPet(id);
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<Void> updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        return petService.updatePet(id, petDTO);
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<Void> removePet(@PathVariable Long id) {
        return petService.removePet(id);
    }

}
