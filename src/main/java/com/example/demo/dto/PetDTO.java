package com.example.demo.dto;


import com.example.demo.model.Customer;
import com.example.demo.model.PetType;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class PetDTO {

    private String name;
    private String type;

}
