package com.example.demo.dto;

import com.example.demo.model.Pet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class CustomerDTO {

    private String name;
    private String username;
    private String password;
    private List<Pet> petList;
}
