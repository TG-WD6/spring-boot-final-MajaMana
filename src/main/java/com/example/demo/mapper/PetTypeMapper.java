package com.example.demo.mapper;

import com.example.demo.dto.PetDTO;
import com.example.demo.dto.PetTypeDTO;
import com.example.demo.model.Pet;
import com.example.demo.model.PetType;

public class PetTypeMapper {

    public static PetTypeDTO toPetTypeDTO(PetType petType) {
        return new PetTypeDTO()
                .setName(petType.getName());
    }

    public static PetType toPetType(PetTypeDTO petTypeDTO) {
        return new PetType()
                .setName(petTypeDTO.getName());
    }

}
