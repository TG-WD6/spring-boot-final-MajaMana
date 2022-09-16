package com.example.demo.mapper;

import com.example.demo.dto.PetDTO;
import com.example.demo.model.Pet;

public class PetMapper {
    public static PetDTO toPetDTO(Pet pet) {
        return new PetDTO()
                .setName(pet.getName());
//                .setType(pet.getType());
//                .setOwner(pet.getOwner().getName());
    }

    public static Pet toPet(PetDTO petDTO) {
        return new Pet()
                .setName(petDTO.getName());
//                .setType(petDTO.getType());
//                .setOwner(petDTO.getOwner());
    }
}
